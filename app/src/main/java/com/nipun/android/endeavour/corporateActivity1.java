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
                        "Monopoly","Rs.150/-",R.drawable.icon_mono));

        corporateList.add(
                new TypeCorporate(
                        2,
                        "B-plan","Rs.300/-",R.drawable.planb));

        corporateList.add(
                new TypeCorporate(
                        3,
                        "Q-fiesta","Rs.150/-", R.drawable.fiesta));

        corporateList.add(
                new TypeCorporate(
                        4,
                        "Suicide Squad","Rs.200/-", R.drawable.icon_suicide));

        corporateList.add(
                new TypeCorporate(
                        5,
                        "Your Story","Rs.150/-", R.drawable.your));




        //creating recyclerview adapter
        TypesCorporateAdapter adapter = new TypesCorporateAdapter(this, corporateList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }
}
