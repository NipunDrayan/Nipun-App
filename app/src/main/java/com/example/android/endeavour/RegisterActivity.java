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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by manvi on 30-12-2017.
 */
public class RegisterActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText inputName, inputYear, inputBranch, inputRoll, inputCollege, inputCampus, inputMobile, inputEmail, inputPassword;
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutPassword, inputLayoutYear, inputLayoutBranch, inputLayoutRoll,
            inputLayoutCollege, inputLayoutCampus, inputLayoutMobile;
    private Button btnSignUp;
    private ProgressBar progressBar;

    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        //setSupportActionBar(toolbar);

        toolbar.setTitle("E-Summit");

        session = new SessionManager(getApplicationContext());
        if (session.isLoggedIn()) {
            startActivity(new Intent(RegisterActivity.this, loginActivity.class));
            finish();
        }

        inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name);
        inputLayoutYear = (TextInputLayout) findViewById(R.id.input_layout_year);
        inputLayoutBranch = (TextInputLayout) findViewById(R.id.input_layout_branch);
        inputLayoutRoll = (TextInputLayout) findViewById(R.id.input_layout_roll);
        inputLayoutCollege = (TextInputLayout) findViewById(R.id.input_layout_college);
        inputLayoutCampus = (TextInputLayout) findViewById(R.id.input_layout_campus);
        inputLayoutMobile = (TextInputLayout) findViewById(R.id.input_layout_mobile);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        inputName = (EditText) findViewById(R.id.etname);
        inputYear = (EditText) findViewById(R.id.etYear);
        inputBranch = (EditText) findViewById(R.id.etBranch);
        inputRoll = (EditText) findViewById(R.id.etUnivRNr);
        inputCollege = (EditText) findViewById(R.id.etCollege);
        inputCampus = (EditText) findViewById(R.id.etCampusAmbId);
        inputMobile = (EditText) findViewById(R.id.etMobNo);
        inputEmail = (EditText) findViewById(R.id.etEmail);
        inputPassword = (EditText) findViewById(R.id.etPassword);
        btnSignUp = (Button) findViewById(R.id.signupid);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        inputName.addTextChangedListener(new MyTextWatcher(inputName));
        inputYear.addTextChangedListener(new MyTextWatcher(inputYear));
        inputBranch.addTextChangedListener(new MyTextWatcher(inputBranch));
        inputRoll.addTextChangedListener(new MyTextWatcher(inputRoll));
        inputCollege.addTextChangedListener(new MyTextWatcher(inputCollege));
        inputCampus.addTextChangedListener(new MyTextWatcher(inputCampus));
        inputMobile.addTextChangedListener(new MyTextWatcher(inputMobile));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPassword.addTextChangedListener(new MyTextWatcher(inputPassword));
        setupUI(findViewById(R.id.rl1));


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = isNetworkAvailable();
                if (check)
                    submitForm();
                else {
                    try {
                        Toast.makeText(RegisterActivity.this, "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        });
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }
    public void setupUI(View view)
    {

        // Set up touch listener for non-text box views to hide keyboard.
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    hideSoftKeyboard(RegisterActivity.this);
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

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateName()) {
            return;
        }
        if (!validateYear()) {
            return;
        }

        if (!validateBranch()) {
            return;
        }

        if (!validateRoll()) {
            return;
        }

        if (!validateCollege()) {
            return;
        }

        /*if (!validateCampus()) {
            return;
        }*/

        if (!validateMobile()) {
            return;
        }

        if (!validateEmail()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }

        String name = inputName.getText().toString().trim();

        int year = Integer.parseInt(inputYear.getText().toString().trim());

        String branch = inputBranch.getText().toString().trim();

        int rollno = Integer.parseInt(inputRoll.getText().toString().trim());

        String mobile = inputMobile.getText().toString().trim();

        String college = inputCollege.getText().toString().trim();

        String campus = inputCampus.getText().toString().trim();

        String username = inputEmail.getText().toString().trim();

        String password = inputPassword.getText().toString().trim();

        progressBar.setVisibility(View.VISIBLE);


        Response.Listener<String> responseListener = new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        finish();
                        startActivity(new Intent(RegisterActivity.this, loginActivity.class));
                        progressBar.setVisibility(View.GONE);

                        Toast.makeText(RegisterActivity.this, "Successfully Registered. Now Login.", Toast.LENGTH_LONG).show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog

                                .Builder(RegisterActivity.this);
                        builder.setMessage("Register Failed")
                                .setNegativeButton("Retry", null)
                                .create().show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        Register_request registerRequest = new Register_request(name, year, branch, rollno, mobile, college, campus, username, password, responseListener);
        RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        registerRequest.setRetryPolicy(policy);
        queue.add(registerRequest);


        //Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
    }


    private boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError("Enter the full name");
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateYear() {
        String year = inputYear.getText().toString().trim();

        if(year.equals("1")||year.equals("2")||year.equals("3")||year.equals("4"))
        {
            inputLayoutYear.setErrorEnabled(false);
        }
        else
        {
            //inputLayoutYear.setErrorEnabled(false);
            inputLayoutYear.setError("Enter valid year");
            requestFocus(inputYear);
            return false;
        }

        return true;
    }


    private boolean validateBranch() {
        if (inputBranch.getText().toString().trim().isEmpty()) {
            inputLayoutBranch.setError("Enter the branch");
            requestFocus(inputBranch);
            return false;
        } else {
            inputLayoutBranch.setErrorEnabled(false);
        }

        return true;
    }


    private boolean validateRoll() {
        if (inputRoll.getText().toString().trim().isEmpty()) {
            inputLayoutRoll.setError("Enter the university roll no");
            requestFocus(inputRoll);
            return false;
        } else {
            inputLayoutRoll.setErrorEnabled(false);
        }

        return true;
    }


    private boolean validateCollege() {
        if (inputCollege.getText().toString().trim().isEmpty()) {
            inputLayoutCollege.setError("Enter the college name");
            requestFocus(inputCollege);
            return false;
        } else {
            inputLayoutCollege.setErrorEnabled(false);
        }

        return true;
    }


    /*private boolean validateCampus() {
        if (inputCampus.getText().toString().trim().isEmpty()) {
            inputLayoutCampus.setError(getString(R.string.err_msg_campus));
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }*/


    private boolean validateMobile() {
        if (inputMobile.getText().toString().trim().isEmpty()) {
            inputLayoutMobile.setError("Enter the mobile number");
            requestFocus(inputMobile);
            return false;
        } else {
            inputLayoutMobile.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError("Enter valid email address");
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePassword() {
        if (inputPassword.getText().toString().trim().isEmpty()) {
            inputLayoutPassword.setError("Enter the Password");
            requestFocus(inputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.etname:
                    validateName();
                    break;
                case R.id.etYear:
                    validateYear();
                    break;
                case R.id.etBranch:
                    validateBranch();
                    break;
                case R.id.etUnivRNr:
                    validateRoll();
                    break;
                case R.id.etCollege:
                    validateCollege();
                    break;
                case R.id.etCampusAmbId:
                    //validateCampus();
                    break;
                case R.id.etMobNo:
                    validateMobile();
                    break;
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
