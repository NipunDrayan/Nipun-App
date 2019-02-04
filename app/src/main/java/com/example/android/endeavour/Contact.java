package com.example.android.endeavour;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Contact extends Fragment
{
    Toolbar toolbar;
    EditText ed3,ed4,ed5;
    TextInputLayout inputLayoutEmail,inputLayoutQuestion,inputLayoutSubject;
    public Contact()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.my_toolbar);
        //setSupportActionBar(toolbar);

        inputLayoutEmail = (TextInputLayout) view.findViewById(R.id.input_layout_email);
        inputLayoutQuestion = (TextInputLayout) view.findViewById(R.id.input_layout_ques);
        inputLayoutSubject = (TextInputLayout) view.findViewById(R.id.input_layout_subject);
        ed3 = (EditText) view.findViewById(R.id.editText3);
        ed4 = (EditText) view.findViewById(R.id.editText4);
        ed5 = (EditText) view.findViewById(R.id.editText5);
        setupUI(view.findViewById(R.id.relativefragment));
        ed3.addTextChangedListener(new MyTextWatcher(ed3));
        ed4.addTextChangedListener(new MyTextWatcher(ed4));
        ed5.addTextChangedListener(new MyTextWatcher(ed5));

        Button b = (Button) view.findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ed3.getText().toString().trim().equals("") || ed4.getText().toString().trim().equals("") || ed5.getText().toString().trim().equals("")) {
                    Toast.makeText(getActivity().getApplicationContext(), "Fill all the entries to submit your query", Toast.LENGTH_SHORT).show();
                } else {
                    String sub = ed3.getText().toString().trim();
                    String from = ed4.getText().toString().trim();
                    String msg = "from : "+ from + "\n Message :: "+ed5.getText().toString().trim();
                    String to = "ecellkiet@gmail.com";
                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");

                                if (success)
                                {
                                    new AlertDialog.Builder(getActivity())
                                            .setTitle("Query Submitted")
                                            .setMessage("Your query is submitted we will contact you soon")
                                            .setPositiveButton("OK", null).create().show();

                                    ed3.setText("");
                                    ed4.setText("");
                                    ed5.setText("");
                                }
                                else
                                {
                                    android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getActivity());
                                    builder.setMessage("Failed")
                                            .setNegativeButton("Retry", null)
                                            .create().show();

                                }
                            } catch (JSONException e) {
                                new AlertDialog.Builder(getActivity())
                                        .setTitle("Query Submitted")
                                        .setMessage("Your query is submitted we will contact you soon.")
                                        .setPositiveButton("OK", null).create().show();
                                ed3.setText("");
                                ed4.setText("");
                                ed5.setText("");

                                e.printStackTrace();
                            }


                        }
                    };

                    ContactRequest contactRequest = new ContactRequest(sub,to, msg, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(getActivity());
                    queue.add(contactRequest);

                }

            }

        });

        return view;
    }

    public static void hideSoftKeyboard(Activity activity) {
       /* InputMethodManager inputMethodManager =
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
                    hideSoftKeyboard(getActivity());
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
                case R.id.editText3:
                    validateSubject();
                    break;
                case R.id.editText4:
                    validateEmail();
                    break;
                case R.id.editText5:
                    validateQuery();
                    break;
            }
        }


        private boolean validateEmail() {
            String email = ed4.getText().toString().trim();

            if (email.isEmpty() || !isValidEmail(email)) {
                inputLayoutEmail.setError("Enter Valid Email-id");
                requestFocus(ed4);
                return false;
            } else {
                inputLayoutEmail.setErrorEnabled(false);
            }

            return true;
        }

        private boolean validateSubject() {
            if (ed3.getText().toString().trim().isEmpty())
            {
                inputLayoutSubject.setError("Subject cannot be empty");
                requestFocus(ed3);
                return false;
            }
            else
            {
                inputLayoutSubject.setErrorEnabled(false);
            }

            return true;
        }
        private boolean validateQuery()
        {
            if (ed5.getText().toString().trim().isEmpty()) {
                inputLayoutQuestion.setError("Subject cannot be empty");
                requestFocus(ed5);
                return false;
            } else {
                inputLayoutQuestion.setErrorEnabled(false);
            }

            return true;
        }
        private  boolean isValidEmail(String email)
        {
            return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }

        private void requestFocus(View view)
        {
            if (view.requestFocus()) {
                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
            }
        }
    }

}