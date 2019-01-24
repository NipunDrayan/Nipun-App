package com.example.android.endeavour;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manvi on 28-11-2017.
 */
public class Login_request extends StringRequest {
    private static final String LOGIN_REQUEST_URL="http://endeavourkiet.in/app17/login.php";
    private Map<String,String> params;

    public Login_request(String username, String password,Response.Listener<String> listener) {
        super(Request.Method.POST,LOGIN_REQUEST_URL, listener,null);
        params=new HashMap<>();
        params.put("username",username);
        params.put("password",password);
    }

    @Override
    public Map<String,String> getParams(){
        return params;
    }
}

