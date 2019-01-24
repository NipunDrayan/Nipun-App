package com.example.android.endeavour;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 */
public class Home1Fragment extends Fragment
{
    TextView name,idname;
    Fragment fragment;
    SessionManager sessionManager;
    String name1,uniqueuserId;

    public Home1Fragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_home1, container, false);
        name=(TextView)rootview.findViewById(R.id.name1);
        idname=(TextView)rootview.findViewById(R.id.idMem);
        sessionManager = new SessionManager(getActivity());
        TextView eventText=(TextView)rootview.findViewById(R.id.myEventsText);
        HashMap<String, String> user = sessionManager.getUserDetails();

        // name
        name1 = user.get(SessionManager.KEY_NAME);

        // email
        //  String email = user.get(SessionManager.KEY_EMAIL);
        uniqueuserId = user.get(SessionManager.KEY_UID);
        name.setText(name1);
        Toast.makeText(getActivity(),uniqueuserId,Toast.LENGTH_SHORT).show();
        idname.setText(uniqueuserId);
        eventText.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                fragment = new MyEvents();
                loadFragment(fragment);
            }
        });
        return rootview;
    }

    private void loadFragment(Fragment fragment)
    {
        // load fragment
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
