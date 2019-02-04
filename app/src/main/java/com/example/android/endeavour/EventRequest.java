package com.example.android.endeavour;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by manvi on 12-01-2018.
 */
public class EventRequest extends StringRequest
{
    static final String EVENT_REQUEST_URL = "http://10.21.85.170:3000/apieventreg";
    private Map<String, String> params;

    public EventRequest(String userid,int eventid, String campus ,String mem1,String mem2,String mem3,Response.Listener<String> listener)
    {

        super(Request.Method.POST, EVENT_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("head_id", userid);
        // params.put("paystatus",pay+"");
       params.put("mbrs",mem1+","+mem2+","+mem3);
        params.put("caid",campus);
        params.put("event" , eventid+"");

      //params.put("mem1",mem1);

      //params.put("mem2",mem2);

    //params.put("mem3",mem3);

    }

    @Override
    public Map<String, String> getParams()
    {
        return params;
    }


}
