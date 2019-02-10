package com.example.android.endeavour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment
{
    TextView login;
    TextView registration;

    public Home()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
       // View rootview =  inflater.inflate(R.layout.fragment_home, container, false);
        View rootview =  inflater.inflate(R.layout.fragment_home, null);
        login=(TextView)rootview.findViewById(R.id.loginlink);
        registration = (TextView)rootview.findViewById(R.id.registerlink);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getActivity(),loginActivity.class));

            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(getActivity(),RegisterActivity.class));
            }
        });

        return rootview;
    }


}