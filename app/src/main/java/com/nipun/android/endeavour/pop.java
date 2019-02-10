package com.example.android.endeavour;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by manvi on 03-02-2018.
 */
public class pop extends Activity {

    private EditText inputName1, inputName2, inputName3;
    private TextInputLayout inputLayoutName1, inputLayoutName2, inputLayoutName3;
    private Button btnSubmit;
    private ProgressBar progressBar;
    private Context mContext;
    int eventId,index;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popactivity);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.6));

        inputLayoutName1 = (TextInputLayout) findViewById(R.id.input_layout_name1);
        inputLayoutName2 = (TextInputLayout) findViewById(R.id.input_layout_name2);
        inputLayoutName3 = (TextInputLayout) findViewById(R.id.input_layout_name3);
        //  inputLayoutName4 = (TextInputLayout) findViewById(R.id.input_layout_name4);
        inputName1 = (EditText) findViewById(R.id.mem1);
        inputName2 = (EditText) findViewById(R.id.mem2);
        inputName3 = (EditText) findViewById(R.id.mem3);
        //inputName4 = (EditText) findViewById(R.id.mem4);
        intent = getIntent();
        index = intent.getIntExtra("eventId", 0);

        btnSubmit = (Button) findViewById(R.id.submitid);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        inputName1.addTextChangedListener(new MyTextWatcher(inputName1));
        inputName2.addTextChangedListener(new MyTextWatcher(inputName2));
        inputName3.addTextChangedListener(new MyTextWatcher(inputName3));
//        inputName4.addTextChangedListener(new MyTextWatcher(inputName4));

        if(index==1)
        {
            inputName3.setEnabled(false);
            inputLayoutName3.setEnabled(false);

        }

        if(index==2)
        {
            if(inputLayoutName3.getVisibility()==View.INVISIBLE)
            {
                inputLayoutName3.setVisibility(View.VISIBLE);
            }
            inputName3.setEnabled(false);
            inputLayoutName3.setEnabled(false);
        }

        if(index==3)
        {
            if(inputLayoutName2.getVisibility()==View.INVISIBLE)
            {
                inputLayoutName2.setVisibility(View.VISIBLE);
            }
            if(inputLayoutName3.getVisibility()==View.INVISIBLE)
            {
                inputLayoutName3.setVisibility(View.VISIBLE);
            }
            inputLayoutName2.setEnabled(false);
            inputName2.setEnabled(false);
            inputName3.setEnabled(false);
            inputLayoutName3.setEnabled(false);
        }
        if(index==4)
        {
            if(inputLayoutName2.getVisibility()==View.INVISIBLE)
            {
                inputLayoutName2.setVisibility(View.VISIBLE);
            }
            if(inputLayoutName3.getVisibility()==View.INVISIBLE)
            {
                inputLayoutName3.setVisibility(View.VISIBLE);
            }
            inputLayoutName2.setEnabled(false);
            inputName2.setEnabled(false);
            inputName3.setEnabled(false);
            inputLayoutName3.setEnabled(false);
        }

        if(index==5)
        {
            if(inputLayoutName2.getVisibility()==View.INVISIBLE)
            {
                inputLayoutName2.setVisibility(View.VISIBLE);
            }
            if(inputLayoutName3.getVisibility()==View.INVISIBLE)
            {
                inputLayoutName3.setVisibility(View.VISIBLE);
            }
            inputLayoutName2.setEnabled(false);
            inputName2.setEnabled(false);
            inputName3.setEnabled(false);
            inputLayoutName3.setEnabled(false);
        }




        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean check = isNetworkAvailable();
                if (check)
                    submitForm();
                else {
                    try {
                        Toast.makeText(pop.this, "NO INTERNET CONNECTION", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        });

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
    private void submitForm()
    {
/*
        if (!validateid1()) {
            return;
        }
        if (!validateid2()) {
            return;
        }
        if (!validateid3()) {
            return;
        }*/
Log.e("INSIDE SIUBMIT","sdfsdfsd");

        String mem1 = inputName1.getText().toString().trim();
        String mem2 = inputName2.getText().toString().trim();
        String mem3 = inputName3.getText().toString().trim();
        // int mem4 = Integer.parseInt(inputName4.getText().toString().trim());

        progressBar.setVisibility(View.VISIBLE);
        String userId="",unique_user_id="";
        userId = intent.getStringExtra("userId");
        //unique_user_id=intent.getStringExtra("unique_user_id");
        unique_user_id=new SessionManager(this).getUserId();
        Log.d(unique_user_id,"head_id");
        //int index = intent.getIntExtra("eventId", 0);
        final String category = intent.getStringExtra("category");
        String campus = intent.getStringExtra("campus");
        int pay = intent.getIntExtra("pay", 0);
Log.e("dfsdfsd","dfdssdf");
        if(index == 1)
        {
            eventId = 1;
            //mem2="";
            mem3="";
        }

        if(index == 2)
        {
            eventId = 2;
            mem3="";

        }

        if(index == 3)
        {
            eventId = 3;
            mem2="";
            mem3="";
        }
        if(index == 4)
        {
            eventId = 4;
           mem2="";
            mem3="";
        }
        if(index == 5)
        {
            eventId = 5;
            mem2="";
            mem3="";
        }



        if(index == 10)
            eventId = 6;

Log.e("before response","sdfsd");
        Response.Listener<String> responseListener = new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success)
                    {

                        if(category.equals("Corporate")) {
                            finish();
                            //startActivity(new Intent(pop.this, corporateActivity1.class));
                            progressBar.setVisibility(View.GONE);
                            AlertDialog.Builder builder = new AlertDialog.Builder(pop.this);
                            builder.setMessage("Successfully Registered")
                                    .setNegativeButton("Close", null)
                                    .create().show();
                            // Toast.makeText(pop.this, "Successfully Submitted", Toast.LENGTH_LONG).show();
                        }
                        else if(category.equals("Hackathon"))
                        {
                            finish();
                            //startActivity(new Intent(pop.this, EventsFrag.class));
                            progressBar.setVisibility(View.GONE);
                            AlertDialog.Builder builder = new AlertDialog.Builder(pop.this);
                            builder.setMessage("Successfully Registered")
                                    .setNegativeButton("Close", null)
                                    .create().show();
                            //Toast.makeText(pop.this, "Successfully Submitted", Toast.LENGTH_LONG).show();
                        }
                    }
                    else
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(pop.this);
                        builder.setMessage("Submission Failed")
                                .setNegativeButton("Retry", null)
                                .create().show();
                    }

                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                    Toast.makeText(mContext, "not able to register", Toast.LENGTH_SHORT).show();
                }
            }
        };
        if(mem1==null)
            mem1="";
        if(mem2==null)
            mem2="";
        if(mem3==null)
            mem3="";
        Log.e("after response","sdfds");
        Log.e("details",String.valueOf(mem1));
        Log.e("details1",String.valueOf(mem2.length()));
        Log.e("details2",String.valueOf(mem3.length()));


        EventRequest eventRequest = new EventRequest(unique_user_id, eventId, campus, mem1, mem2, mem3, responseListener);
        RequestQueue queue = Volley.newRequestQueue(pop.this);
        queue.add(eventRequest);
        Log.e("after request","sdfdsf");

    }

    private boolean validateid1() {
        if (inputName1.getText().toString().trim().isEmpty()) {
            inputLayoutName1.setError("Enter the id");
            requestFocus(inputName1);
            return false;
        } else {
            inputLayoutName1.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateid2() {
        if (inputName2.getText().toString().trim().isEmpty()) {
            inputLayoutName2.setError("Enter the id");
            requestFocus(inputName2);
            return false;
        } else {
            inputLayoutName2.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateid3() {
        if (inputName3.getText().toString().trim().isEmpty()) {
            inputLayoutName3.setError("Enter the id");
            requestFocus(inputName3);
            return false;
        } else {
            inputLayoutName3.setErrorEnabled(false);
        }

        return true;
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
                case R.id.mem1:
                    validateid1();
                    break;
                case R.id.mem2:
                    validateid2();
                    break;
                case R.id.mem3:
                    validateid3();
                    break;
            /*  case R.id.mem4:
                    validateid4();
                    break;*/

            }
        }
    }
}