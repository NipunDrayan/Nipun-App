package com.example.android.endeavour;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FragRules extends Fragment {

    public static FragRules newInstance(int index) {
        Bundle args = new Bundle();
        args.putInt("index", index);
        FragRules fragment = new FragRules();
        fragment.setArguments(args);
        return fragment;
    }
    View view;

    List<String> rules=new ArrayList<String>();

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.rules, container, false);
        rules.add("rule1");
        rules.add("rule2");
        rules.add("rule3");
        rules.add("rule4");
        rules.add("rule5");


        //Toast.makeText(getActivity(),rules.get(getArguments().getInt("index")),Toast.LENGTH_LONG).show();
        if (getArguments().getInt("index")==1)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. Final decision of game/auction will be decided by the event head.\n" +
                            "\n"+
                            "2.No member will be allowed to leave the venue at the time of game round. \n"+
                            "3.Only round 1 qualifiers will participate in the game round and auction round.\n"+
                            "4.The team with the maximum strength will get the winning prize.\n"+
                            "5.No participant is allowed to question the strength provided by us to the accessories.\n");
        }
        if (getArguments().getInt("index")==2)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. Business idea must be unique and feasible.\n" +
                            "2.The team without the proper format of the presentation will be disqualified.\n"+
                            "3.There is no need for laptops for presentation.\n");
        }
        if (getArguments().getInt("index")==3)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1.The participant with the highest score will win the game. \n"+
                            "\n"+
                            "2.In case of any tie, there will be a tie-breaker question.\n"+
                            "\n"+
                            "3. Participant should answer in given time limit.\n"+
                            "\n"+
                    "4. No withdrawn after registration.");
        }
        if (getArguments().getInt("index")==4)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1.No member will be allowed to leave the venue at the time of auction. \n" +
                            "\n"+
                            "2. Only one player will be allowed to do auction at a time.\n"+
                            "\n"+
                            "3.Only round 1 qualifiers will participate in the auction round. \n"+
                    "\n"+
                    "4. Maximum of 8 characters are allowed in a team.\n"+
                            "5.The team with the maximum strength will get the winning prize. \n" +
                            "\n"+
                            "6.Every team should attend minimum 10 questions in round 1 and negative marking will be there. \n"+
                            "\n"+
                            "7. Genre of the character is decided by the auctioneers only.\n");
        }
        if (getArguments().getInt("index")==5)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            " Only the area where the E Summit events are taking place should be covered.\n" +
                            "\n"+
                            "1.All the other college region is restricted. \n"+
                            "\n" +
                            "2.Anyone found roaming or breaking the rules will be then and there disqualified. \n" +
                            "\n"+
                            "3.Pictures and videos can be taken both from mobile and camera. \n"+
                            "\n" +
                            "4. The article should be within the defined word limit.\n" +
                            "\n"+
                            "5. Any other person roaming or helping them may cause disqualification of the team.\n"+
                            "\n"+
                    "6. Objectionable content will not be entertained.\n");
        }

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return view;
    }
}
