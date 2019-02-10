package com.example.android.endeavour;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manvi on 12-01-2018.
 */
public class EventRequest extends StringRequest
{
    static final String EVENT_REQUEST_URL = "http://endeavourkiet.in/apieventrgister";
    private Map<String, String> params;

    public EventRequest(String userid,int eventid, String campus ,String mem1,String mem2,String mem3,Response.Listener<String> listener)
    {

        super(Request.Method.POST, EVENT_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("head_id", String.valueOf(userid));
        // params.put("paystatus",pay+"");
      // params.put("mbrs",mem1+","+mem2+","+mem3);
        if(campus==null)
            campus="";
        params.put("caid",campus);
        params.put("event" , String.valueOf(eventid));

      params.put("mem1",mem1);
      params.put("mem2",mem2);
      params.put("mem3",mem3);

     //   Log.e("useid",userid);

        //Log.e("params",String.valueOf(params));

    }

    @Override
    public Map<String, String> getParams()
    {
        if(params==null)
            return Collections.<String, String>emptyMap();
        return params;
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        if (response.headers == null)
        {
            // cant just set a new empty map because the member is final.
            response = new NetworkResponse(
                    response.statusCode,
                    response.data,
                    Collections.<String, String>emptyMap(), // this is the important line, set an empty but non-null map.
                    response.notModified,
                    response.networkTimeMs);


        }

        return super.parseNetworkResponse(response);
    }
}
