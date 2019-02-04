package com.example.android.endeavour;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyEvents extends Fragment implements Response.Listener<String>
{
    SessionManager sessionManager;
    ProgressDialog progressDialog;
    String userId;
    public MyEvents()
    {
        // Required empty public constructor
    }


    final String TAG = this.getClass().getSimpleName();
    ListView list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_events, container, false);
        progressDialog = new ProgressDialog(getActivity());
        sessionManager = new SessionManager(getActivity());

        HashMap<String, String> user = sessionManager.getUserDetails();

        // name

        userId = user.get(SessionManager.KEY_ID);

        progressDialog.setMessage("Loading!!!");
        progressDialog.setCancelable(false);
        String url = "http://endeavourkiet.in/app17/eventsview.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, (Response.Listener<String>) this, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> params = new HashMap<String, String>();
                params.put("id",userId);
                return params;
            }
        };

        progressDialog.show();
        MySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);
        list = (ListView) view.findViewById(R.id.listVie2);
        return view;
    }

    @Override
    public void onResponse(String response)
    {

        Log.d(TAG,response);
        ArrayList<Product> productList = new JsonConverter<Product>().toArrayList(response,Product.class);
        BindDictionary<Product> dictionary = new BindDictionary<>();
        try{
            dictionary.addStringField(R.id.event, new StringExtractor<Product>()
            {
                @Override
                public String getStringValue(Product item, int position)
                {
                    String events = null;
                    if(item.eventid.equals("7"))
                    {
                        events = "Monopoly";
                    }
                    if(item.eventid.equals("2"))
                    {
                        events = "B-plan";
                    }
                    if(item.eventid.equals("3"))
                    {
                        events = "B-Noesis";
                    }
                    if(item.eventid.equals("5"))
                    {
                        events = "BID IT!";
                    }
                    if(item.eventid.equals("4"))
                    {
                        events = "Maestro";
                    }
                    if(item.eventid.equals("6"))
                    {
                        events = "Dropout";
                    }
                    if(item.eventid.equals("8"))
                    {
                        events = "Your Story";
                    }

                    if(item.eventid.equals("1"))
                    {
                        events = "Hackathon";
                    }
                    return events;
                }
            });

            dictionary.addStringField(R.id.paystatus, new StringExtractor<Product>()
            {
                String pay;
                @Override
                public String getStringValue(Product item, int position)
                {

                    //Toast.makeText(getActivity(),item.paystatus,Toast.LENGTH_SHORT).show();
                    if(item.paystatus.equals("0"))
                        pay = "Not Paid";
                    if(item.paystatus.equals("1"))
                        pay = "Paid";
                    if(item.paystatus.equals("2"))
                        pay = "Contact Team";
                    return pay;
                }
            });


            FunDapter<Product> adapter = new FunDapter<>(getContext(), productList, R.layout.rowitem, dictionary);
            list.setAdapter(adapter);
            progressDialog.dismiss();
        }
        catch (Exception e)
        {
            Toast.makeText(getActivity(),"No registered events",Toast.LENGTH_SHORT).show();
        }
    }

}
