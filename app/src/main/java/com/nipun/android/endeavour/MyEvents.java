package com.example.android.endeavour;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
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
    String head_id="";
    Intent intent;
    public MyEvents()
    {
        // Required empty public constructor
    }


    final String TAG = this.getClass().getSimpleName();
    RecyclerView list;
    //MainAdapter mainAdapter;
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

        head_id = user.get(SessionManager.KEY_UID);
         //head_id="ENDVR1907355487915";
        head_id=new SessionManager(getContext()).getUserId();
         Log.d(head_id,"head id");
        progressDialog.setMessage("Loading!!!");
        progressDialog.setCancelable(false);
        String url = "http://endeavourkiet.in/apiregisterdevent";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, (Response.Listener<String>) this, new Response.ErrorListener() {
            @Override
            /*public void onErrorResponse(VolleyError error)
            {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }*/
            public void onErrorResponse(VolleyError error) {

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    //Toast.makeText(context,context.getString(R.string.error_network_timeout),Toast.LENGTH_LONG).show();
                    Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                } else if (error instanceof AuthFailureError) {
                    //TODO
                } else if (error instanceof ServerError) {
                    //TODO
                } else if (error instanceof NetworkError) {
                    //TODO
                } else if (error instanceof ParseError) {
                    //TODO
                }
            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> params = new HashMap<String, String>();
                params.put("head_id",head_id);
                return params;
            }
        };

        progressDialog.show();
        MySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);
        list = (RecyclerView) view.findViewById(R.id.listVie2);
        return view;
    }

    @Override
    public void onResponse(String response)
    {

        Log.d(TAG,new Gson().toJson(response));
        String r=new Gson().toJson(response);
        try {
            Product product = new Gson().fromJson(response, Product.class);
            HashMap<String, String> hm = new HashMap<>();
            String pay = "null";
            ArrayList<String> listEvent = new ArrayList<>();
            for (int i = 0; i < product.getEventid().size(); i++) {
                if (product.getEventid().get(i) == 1) {
                    if (product.getPaystatus().get(i) == 0)
                        pay = "Not Paid";
                    if (product.getPaystatus().get(i) == 1)
                        pay = "Paid";
                    hm.put("Monopoly", pay);
                    listEvent.add("Monopoly");

                }


                if (product.getEventid().get(i) == 2) {

                    if (product.getPaystatus().get(i) == 0)
                        pay = "Not Paid";
                    if (product.getPaystatus().get(i) == 1)
                        pay = "Paid";

                    hm.put("B-Plan", pay);
                    listEvent.add("B-Plan");
                }
                if (product.getEventid().get(i) == 3) {

                    if (product.getPaystatus().get(i) == 0)
                        pay = "Not Paid";
                    if (product.getPaystatus().get(i) == 1)
                        pay = "Paid";

                    hm.put("Q-fiesta", pay);
                    listEvent.add("Q-fiesta");

                }
                if (product.getEventid().get(i) == 4) {

                    if (product.getPaystatus().get(i) == 0)
                        pay = "Not Paid";
                    if (product.getPaystatus().get(i) == 1)
                        pay = "Paid";

                    hm.put("Suicide Squad", pay);
                    listEvent.add("Suicide Squad");

                }
                if (product.getEventid().get(i) == 5) {
                    if (product.getPaystatus().get(i) == 0)
                        pay = "Not Paid";
                    if (product.getPaystatus().get(i) == 1)
                        pay = "Paid";
                    hm.put("Your Story", pay);
                    listEvent.add("Your Story");
                }


                if (product.getEventid().get(i) == 6) {
                    if (product.getPaystatus().get(i) == 0)
                        pay = "Not Paid";
                    if (product.getPaystatus().get(i) == 1)
                        pay = "Paid";
                    hm.put("Hackathon", pay);
                    listEvent.add("Hackathon");
                }


            }

            Log.e("data", hm.toString());
            Log.e("data2", listEvent.toString());

            EventsAdapter eventsAdapter = new EventsAdapter(getContext(), hm, listEvent);
            list.setLayoutManager(new LinearLayoutManager(getContext()));
            list.setAdapter(eventsAdapter);
            progressDialog.dismiss();
        }
        catch(Exception e)
        {
            Toast.makeText(getActivity(),"No registered events",Toast.LENGTH_SHORT).show();
        }
        }
        /*
        ArrayList<Product> productList = new JsonConverter<Product>().toArrayList(response,Product.class);
        BindDictionary<Product> dictionary = new BindDictionary<>();
        try{
            dictionary.addStringField(R.id.event, new StringExtractor<Product>()
            {
                @Override
                public String getStringValue(Product item, int position) {
                    String events = null;
                    for (int i = 0; i < item.getEventid().size(); i++) {
                        if (item.getEventid().get(i) == 1) {
                            events = "Monopoly";
                        }
                        if (item.getEventid().get(i) == 2) {
                            events = "B-plan";
                        }
                        if (item.getEventid().get(i) == 3) {
                            events = "Q-fiesta";
                        }
                        if (item.getEventid().get(i) == 4) {
                            events = "Suicide Squad";
                        }
                        if (item.getEventid().get(i) == 5) {
                            events = "Your Story";
                        }


                        if (item.getEventid().get(i) == 6) {
                            events = "Hackathon";
                        }

                    }
                    return events;
                }
            });

            dictionary.addStringField(R.id.paystatus, new StringExtractor<Product>() {
                String pay;

                @Override
                public String getStringValue(Product item, int position) {

                    //Toast.makeText(getActivity(),item.paystatus,Toast.LENGTH_SHORT).show();
                    for (int i = 0; i < item.getPaystatus().size(); i++) {
                        if (item.getPaystatus().get(i) == 0)
                            pay = "Not Paid";
                        if (item.getPaystatus().get(i) == 1)
                            pay = "Paid";


                    }
                    return pay;
                }
            });


            FunDapter<Product> adapter = new FunDapter<>(getContext(), productList, R.layout.rowitem, dictionary);
            //list.setAdapter(adapter);
            progressDialog.dismiss();

        }
        catch (Exception e)
        {
            Toast.makeText(getActivity(),"No registered events",Toast.LENGTH_SHORT).show();
        }
    }
    */

}
