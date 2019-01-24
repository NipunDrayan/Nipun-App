package com.example.android.endeavour;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manvi on 05-01-2018.
 */

/**
 * Created by manvi on 05-01-2018.
 */
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
        rules.add("rule6");
        rules.add("rule7");
        rules.add("rule8");
        rules.add("rule9");
        rules.add("rule10");
        rules.add("rule11");

        //Toast.makeText(getActivity(),rules.get(getArguments().getInt("index")),Toast.LENGTH_LONG).show();
        if (getArguments().getInt("index")==1)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. There will be no change in the theme after the lucky draw\n" +
                            "\n"+
                            "2. Number of team members required is mentioned in the description. Please make sure that you have the right numbers before reaching any competition venue.\n");
        }
        if (getArguments().getInt("index")==2)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. The business idea must be unique and feasible.\n" +
                            "\n"+
                            "2. The basic elements of the B plan must be included in the presentation.\n"+
                            "\n"+
                            "3. There is no need to bring laptops for presentation.");
        }
        if (getArguments().getInt("index")==3)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. The participant with the highest score will win the game.\n" +
                            "\n"+
                            "2. In case of any tie,there will be a tie breaker question.\n"+
                            "\n"+
                            "3. Every team will be provided with a single P.C.\n"+
                            "\n"+
                    "4. If participants use hints then marks will be reduced accordingly.");
        }
        if (getArguments().getInt("index")==4)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. The final decision of auction will be decided by an auctioneer.\n" +
                            "\n"+
                            "2. No member will be allowed to leave the venue at the time of an auction.\n"+
                            "\n"+
                            "3. Only one player will be allowed to do auction at a time.\n"+
                    "\n"+
                    "4. Only round 1 qualifiers will participate in the auction round.\n");
        }
        if (getArguments().getInt("index")==5)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. In case of any dispute, the decision given by the judges will be final.\n" +
                            "\n"+
                            "2. The position in the boardroom will be given on the spot.\n"+
                            "\n"+
                    "3. The event will proceed in the form of a formal manager selection process .");
        }
        if (getArguments().getInt("index")==6)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. Abusive or objectionable content will not be entertained.\n\n"+
                            "\n"+
                            "2. PDF not according to the prescribed manner will not be accepted.\n"+
                            "\n"+
                            "3. Presentation exceeding the time limit will be stopped then and there.\n"+
                            "\n"+
                            "4. The decision of the judges will be final.\n"+
                            "\n"+
                            "5. Only one solution of the given problem will be accepted.\n"+
                            "\n"+
                            "6. Given problem will not be changed.\n"+
                            "\n"+
                            "7. Any kind of indiscipline may lead to your disqualification.\n"+
                            "\n"+
                            "8. College ID is must to participate.\n");
        }
        if (getArguments().getInt("index")==7 || getArguments().getInt("index")==8)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. Only the area where the E Summit events are taking place should be covered.\n"+
                            "\n"+
                            "2. All the other college region is restricted.\n"+
                            "\n"+
                            "3. Anyone found roaming or breaking the rules will be then and there disqualified.\n"+
                            "\n"+
                            "4. Pictures and videos can be taken both from mobile and camera.\n"+
                            "\n"+
                            "5. The article should be within the defined word limit.\n"+
                            "\n"+
                            "6. Any other person roaming or helping with them may cause disqualification of the team.\n"+
                            "\n"+
                            "7. Objectionable content will not be entertained.\n");
        }
        if (getArguments().getInt("index")==9)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                           "1. Any changes made after the beginning of dictation of situation will not be counted.\n"+
                            "\n"+
                            "2. The situation will be dictated only twice.\n"+
                            "\n"+
                            "3. Any kind of indiscipline act will lead to disqualification.\n"+
                            "\n"+
                            "4. Crosstalk between different teams will not be entertained.\n"+
                            "\n"+
                            "5. Allotment of points should be done in the given time only.\n"+
                            "\n"+
                            "6. Orders by the coordinators should be solely abided.\n");
        }
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return view;
    }
}
