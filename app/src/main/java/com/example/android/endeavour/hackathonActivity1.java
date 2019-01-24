package com.example.android.endeavour;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class hackathonActivity1 extends AppCompatActivity
{
    Context mContext;
    SessionManager session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackathon1);
        //Adding toolbar to the activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Hackathon");
        toolbar.setNavigationIcon(R.drawable.backspace_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //startActivity(new Intent(getApplicationContext(),EventsFrag.class));
            }
        });


        TextView st=(TextView)findViewById(R.id.st);
        TextView rl=(TextView)findViewById(R.id.rl);
        Button hd=(Button)findViewById(R.id.hackathon_reg_id);

        session = new SessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        // name
        // email
        final String userId = user.get(SessionManager.KEY_ID);
        String name = user.get(SessionManager.KEY_NAME);
        //String username = userId;
        final int pay = 0;
        final int eventId=10;
       final String category = "Hackathon";
      if(!(session.isLoggedIn()))
        {
            hd.setVisibility(View.INVISIBLE);
        }

        hd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(hackathonActivity1.this, pop.class);
                intent.putExtra("userId", userId);
                intent.putExtra("eventId", eventId);
                intent.putExtra("category", category);
                intent.putExtra("pay", pay);
                startActivity(intent);

            }
        });
    }
}
