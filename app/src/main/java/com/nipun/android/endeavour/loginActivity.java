package com.example.android.endeavour;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by manvi on 29-12-2017.
 */
public class loginActivity extends AppCompatActivity
{
    private EditText inputEmail, inputPassword;
    Button LoginBt;
    private TextInputLayout inputLayoutEmail, inputLayoutPassword;
    TextView RegisterTv;
    private ProgressBar progressBar;
    Toolbar mytoolbar;
    //SharedPreferences sp;
    private SessionManager session;
    // ProgressDialog progressDialog;

    //   SharedPreferences.Editor editor = sp.edit();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        mytoolbar = (Toolbar) findViewById(R.id.my_toolbar);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        inputEmail = (EditText) findViewById(R.id.etEmail);
        inputPassword = (EditText) findViewById(R.id.etPassword);
        LoginBt = (Button) findViewById(R.id.blogin);
        RegisterTv = (TextView) findViewById(R.id.tvregister);
        //   progressDialog = new ProgressDialog(this);
        // progressDialog.setMessage("Signing...");
        session = new SessionManager(getApplicationContext());
        mytoolbar.setTitle("E-Summit");

        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));
        setupUI(findViewById(R.id.rl3));
        if(session.isLoggedIn())
        {
            Intent intent = new Intent(loginActivity.this,Main2Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }

        RegisterTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginActivity.this,RegisterActivity.class));
                finish();
            }
        });

        LoginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                boolean check = isNetworkAvailable();
                if(check) {
                    progressBar.setVisibility(View.VISIBLE);
                    submitForm();

                }
                else{
                    try
                    {
                        Toast.makeText(loginActivity.this,"NO INTERNET CONNECTION",Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void hideSoftKeyboard(Activity activity) {
        /*InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);*/
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void setupUI(View view)
    {
        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(loginActivity.this);
                    return false;
                }
            });
        }

        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView);
            }
        }
    }

    private boolean isNetworkAvailable()
    {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void submitForm()
    {
        if (!validateEmail())
        {
            return;
        }

        if (!validatePassword())
        {
            return;
        }


        final String username = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();





        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("validate");

                    if(success)
                    {
//                        progressDialog.show();
                        progressBar.setVisibility(View.GONE);

                        String name = jsonResponse.getString("name");
                        String userId  = jsonResponse.getString("id");
                        String unique_user_id = jsonResponse.getString("unique_user_id");
                        finish();
                        session.setLogin(true);
                        Log.e("USERID",unique_user_id);
                        session.createLoginSession(name,username,userId,unique_user_id);

                        Intent intent = new Intent(loginActivity.this, Main2Activity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("id", userId);


                        loginActivity.this.startActivity(intent);
                        Toast.makeText(loginActivity.this,"Login Succesful",Toast.LENGTH_SHORT).show();
                        MainActivity activity = new MainActivity();
                        activity.finish();
                        //progressDialog.dismiss();


                    }
                    else
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(loginActivity.this);
                        builder.setMessage("Login Failed")
                                .setNegativeButton("Retry", null)
                                .create().show();
                        progressBar.setVisibility(View.GONE);
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }


            }
        };

        Login_request loginRequest = new Login_request(username, password, responseListener);
        RequestQueue queue = Volley.newRequestQueue(loginActivity.this);
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        loginRequest.setRetryPolicy(policy);
        queue.add(loginRequest);

    }

    /* @Override
     public void onBackPressed()
     {
         super.onBackPressed();
         startActivity(new Intent(this,MainActivity.class));
     }
 */
    private boolean validateEmail()
    {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email))
        {
            inputLayoutEmail.setError("Enter valid email address");
            requestFocus(inputEmail);
            return false;
        }
        else
        {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword()
    {
        if (inputPassword.getText().toString().trim().isEmpty())
        {
            inputLayoutPassword.setError("Enter the password");
            requestFocus(inputPassword);
            return false;
        }
        else
        {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email)
    {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view)
    {
        if (view.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher
    {

        private View view;

        private MyTextWatcher(View view)
        {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
        {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
        {

        }

        public void afterTextChanged(Editable editable)
        {
            switch (view.getId())
            {
                case R.id.etEmail:
                    validateEmail();
                    break;
                case R.id.etPassword:
                    validatePassword();
                    break;
            }
        }
    }


}


