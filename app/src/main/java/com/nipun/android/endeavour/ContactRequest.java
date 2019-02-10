package com.example.android.endeavour;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manvi on 30-12-2017.
 */

public class ContactRequest extends StringRequest
{
    static final String CONTACT_REQUEST_URL = "http://endeavourkiet.in/apicontact";
    private Map<String, String> params;

    public ContactRequest(String sub,String from, String msg,Response.Listener<String> listener)
    {
        super(Method.POST, CONTACT_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("sub", sub);
        params.put("to" , from);
        params.put("msg",msg);

    }

    @Override
    public Map<String, String> getParams()
    {
        return params;
    }

}

