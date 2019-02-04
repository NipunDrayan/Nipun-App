package com.example.android.endeavour;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFrag extends Fragment
{
    //a list to store all the events
    List<TypeEvents> eventsList;
//the cardview
    CardView cardview;
    //the recyclerview
    RecyclerView recyclerView;
    public EventsFrag()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.fragment_events, container, false);
        //View view =  inflater.inflate(R.layout.fragment_events, null);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        cardview =(CardView)view.findViewById(R.id.cardview1);

        //initializing the eventslist
        eventsList = new ArrayList<>();


        //adding some items to our list
        eventsList.add(
                new TypeEvents(
                        1,
                        "Speakers",R.drawable.speakers));

        eventsList.add(
                new TypeEvents(
                        2,
                        "Corporate Events",R.drawable.corporate_white));

        eventsList.add(
                new TypeEvents(
                        3,
                        "Hackathon", R.drawable.hack));


        //creating recyclerview adapter
        TypesEventAdapter adapter = new TypesEventAdapter(getActivity(), eventsList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        return view;
    }
}

