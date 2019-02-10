package com.example.android.endeavour;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class TabMainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener
{
    //This is our tablayout
    private TabLayout tabLayout;
private Context mContext;

    //This is our viewPager
    SessionManager session;
    private ViewPager viewPager;
        int index;
    int eventId;
    private int[] tabIcons = {
            R.drawable.structurewhite_min,
            R.drawable.rulewhite_min,
            R.drawable.faqwhite_min
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_main);

        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
       // ab.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.backspace_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        Button button=(Button)findViewById(R.id.btevent);

        index=getIntent().getExtras().getInt("index");
       // eventId =getIntent().getExtras().getInt("position");

        session = new SessionManager(mContext);
        HashMap<String, String> user = session.getUserDetails();
        // name
        // email
        String userId = user.get(SessionManager.KEY_ID);
        String name = user.get(SessionManager.KEY_NAME);
        //String username = userId;
        int pay = 0;
        String category = "Corporate";
        if(!(session.isLoggedIn()))
        {
            button.setVisibility(View.INVISIBLE);
        }

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Structure"));
        tabLayout.addTab(tabLayout.newTab().setText("Rules"));
        tabLayout.addTab(tabLayout.newTab().setText("FAQ"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(3);
        tabLayout.setupWithViewPager(viewPager);
        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount(),index);

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);
        setupTabIcons();

        button.setOnClickListener(new MyItemClickListener(index)); /* new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");


                            if (success)
                            {
                                Toast.makeText(mContext, "Successfully Registered", Toast.LENGTH_LONG).show();
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                                builder.setMessage("Already Registered")
                                        .setNegativeButton("Close", null)
                                        .create().show();
                            }

                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                            Toast.makeText(mContext, "not able to register", Toast.LENGTH_SHORT).show();
                        }
                    }
                };
                EventRequest eventRequest = new EventRequest(userId, eventId, category,pay, responseListener);
                RequestQueue queue = Volley.newRequestQueue(mContext);
                queue.add(eventRequest);

            }
        });*/
    }

    private void setupTabIcons() {

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    public TabMainActivity()
    {
        this.mContext=this;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab)
    {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab)
    {}

    @Override
    public void onTabReselected(TabLayout.Tab tab) {}

    class MyItemClickListener implements View.OnClickListener
    {
        int eventId;
        public SessionManager session;
        public MyItemClickListener(int eventId)

        {
            this.eventId=eventId;
        }

        @Override
        public void onClick(View v) {
            session = new SessionManager(mContext);
            HashMap<String, String> user = session.getUserDetails();
            // name
            // email
            String userId = user.get(SessionManager.KEY_ID);
            String campus = user.get(SessionManager.KEY_CID);
            String name = user.get(SessionManager.KEY_NAME);
            //String username = userId;
            int pay = 0;
            String category = "Corporate";
            // Toast.makeText(mContext,userId,Toast.LENGTH_SHORT).show();
            // Toast.makeText(mContext,name,Toast.LENGTH_SHORT).show();

            if (eventId == 7)
            {
                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");


                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                                builder.setMessage("Successfully Registered")
                                        .setNegativeButton("Close", null)
                                        .create().show();

                               // Toast.makeText(mContext, "Successfully Registered", Toast.LENGTH_LONG).show();

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                                builder.setMessage("Already Registered")
                                        .setNegativeButton("Close", null)
                                        .create().show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(mContext, "not able to register", Toast.LENGTH_SHORT).show();
                        }
                    }
                };
                EventRequest eventRequest = new EventRequest(userId, 7, campus, "", "", "", responseListener);
                RequestQueue queue = Volley.newRequestQueue(mContext);
                queue.add(eventRequest);
            }

            else
            {
                Intent intent = new Intent(TabMainActivity.this, pop.class);
                intent.putExtra("userId", userId);
                intent.putExtra("eventId", eventId);
                intent.putExtra("category", category);
                intent.putExtra("campus",campus);
                intent.putExtra("pay", pay);
                startActivity(intent);
            }
        }
    }
}
