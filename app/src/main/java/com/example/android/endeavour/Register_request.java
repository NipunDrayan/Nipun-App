package com.example.android.endeavour;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manvi on 28-11-2017.
 */
public class Register_request extends StringRequest {

    private static final String REGISTER_REQUEST_URL="http://endeavourkiet.in/app17/register.php";
    private Map<String,String> params;

    public Register_request(String name, int year, String branch, int rollno, String mobile, String college, String campus, String username, String password, Response.Listener<String> listener){

        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("year", year + "");
        params.put("branch", branch);
        params.put("rollno", rollno + "");
        params.put("mobile", mobile);
        params.put("college", college);
        params.put("campus", campus);
        params.put("username", username);
        params.put("password", password);
    }
    @Override
    public Map<String,String> getParams(){
        return params;
    }
}

