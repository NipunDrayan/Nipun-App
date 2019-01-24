package com.example.android.endeavour;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class corporateActivity1 extends AppCompatActivity
{

    //a list to store all the events
    List<TypeCorporate> corporateList;

    //the recyclerview
    RecyclerView recyclerView;
    Toolbar myToolbar;
    //the cardview
    CardView cardview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corporate1);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Corporate Events");
        myToolbar.setNavigationIcon(R.drawable.backspace_white);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //startActivity(new Intent(getApplicationContext(),EventsFrag.class));
            }
        });

       /* cardview =(CardView)view.findViewById(R.id.cardview2);
        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TabMainActivity.class));
            }
        });*/

        //initializing the eventslist
        corporateList = new ArrayList<>();


        //adding some items to our list
        corporateList.add(
                new TypeCorporate(
                        1,
                        "Startup Challenge","Rs.150/-",3000,R.drawable.startupchallenge1));

        corporateList.add(
                new TypeCorporate(
                        2,
                        "B-plan","Rs.300/-",3000,R.drawable.bplan));

        corporateList.add(
                new TypeCorporate(
                        3,
                        "B-Quiz","Fee:Rs.100/-",4000, R.drawable.b_noesis));

        corporateList.add(
                new TypeCorporate(
                        4,
                        "BID IT!","Rs.300/-",7000, R.drawable.bidit));

        corporateList.add(
                new TypeCorporate(
                        5,
                        "Maestro","Rs.200/-",2500, R.drawable.maestro));

        corporateList.add(
                new TypeCorporate(
                        6,
                        "Dropout","Rs.150/-",2500, R.drawable.dropout));

        corporateList.add(
                new TypeCorporate(
                        7,
                        "Your Story Video","Rs.150/-",2500, R.drawable.urstory));//change icon
        corporateList.add(
                new TypeCorporate(
                        8,
                        "Your Story Photo","Rs.150/-",2500, R.drawable.urstory));//change icon
        corporateList.add(
                new TypeCorporate(
                        9,
                        "Art Of Conquest","Rs.250/-",2500, R.drawable.investment));//change icon


        //creating recyclerview adapter
        TypesCorporateAdapter adapter = new TypesCorporateAdapter(this, corporateList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }
}
