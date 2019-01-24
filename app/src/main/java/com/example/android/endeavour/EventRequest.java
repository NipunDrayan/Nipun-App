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
    static final String EVENT_REQUEST_URL = "http://endeavourkiet.in/app17/eventregister.php";
    private Map<String, String> params;

    public EventRequest(String userid,int eventid, String campus ,String mem1,String mem2,String mem3,Response.Listener<String> listener)
    {

        super(Request.Method.POST, EVENT_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("head_id", userid);
        // params.put("paystatus",pay+"");
        params.put("mbrs",mem1+","+mem2+","+mem3);
        params.put("campusId",campus);
        params.put("eventid" , eventid+"");
      //  params.put("mem2",mem2);
     //   params.put("mem3",mem3);
//        params.put("mem4",mem4+"");

    }

    @Override
    public Map<String, String> getParams()
    {
        return params;
    }


}
