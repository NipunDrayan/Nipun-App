package com.example.android.endeavour;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FragFaq extends Fragment {

    public static FragFaq newInstance(int index) {
        Bundle args = new Bundle();
        args.putInt("index", index);
        FragFaq fragment = new FragFaq();
        fragment.setArguments(args);
        return fragment;
    }
    View view;

    List<String> faq=new ArrayList<String>();


    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.faq, container, false);
        faq.add("faq1");
        faq.add("faq2");
        faq.add("faq3");
        faq.add("faq4");
        faq.add("faq5");



        //Toast.makeText(getActivity(),faq.get(getArguments().getInt("index")),Toast.LENGTH_LONG).show();
        if (getArguments().getInt("index")==1) {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. Can the number of players be varied?\n" + "" +
                            "Ans- No\n" +
                            "\n" +
                            "2. How many rounds will be taken of the board during game round?\n" + "" +
                            "Ans- 2\n" + "" +
                            "\n" +
                            "3.Case study will be based on what themes?\n\n" +
                            "Ans-Simple business related cases.\n"+
                            "\n" +
                                    "4.Mode of payment?\n" +
                                    "Ans-Online and offline both.\n"+
                            "\n" +
                                    "5.Can teams contain members of all years? \n" +
                                    "Ans-The teams can be made on any basis irrespective of the years.\n");
        }
        if (getArguments().getInt("index")==2)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. Are intercollege members allowed to form a single team?\n"+
                            "Ans-Yes, intercollege members are allowed to form a single team.\n"+
                            "\n"+
                            "2. What points must be kept in mind while preparing for the presentation? \n"+""+
                            "Ans-- Since presentation is a shorthand representation of your business idea, therefore, it must contain a brief introduction to all related points. \n"+
                            "\n"+
                            "3.What modes can we use for our presentation? \n"+
                            "Ans-The presentation on the final round will be a .ppt. There is no need to make any file or a hard copy of your business plan.\n"+
                            "\n"+
                            "4.Can we extend the time limit allotted to us?\n"+
                            "Ans.Extension of the time is not allowed. \n"+
                            "\n"+
                            "5. Is there any criteria regarding team size?\n"+
                            "Ans- The maximum size of the team is 3 members,an even single person can also represent his idea but more than 3 members are not allowed.\n");
        }

        if (getArguments().getInt("index")==3)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. Are inter-college members allowed forming a single team? \n" +
                            "Ans- Yes, inter-college members are allowed to form a single team. \n"+
                            "\n"+
                            "2. Is there any criteria regarding team size?\n"+""+
                            "Ans- The maximum size of the team is 2 members,an even person can also represent himself but more than 2 members are not allowed. "+
                            "\n"+
                            "3. Can we participate in the online round from anywhere using an internet connection?\n"+
                            "Ans- No, the online round will be conducted at the venue. Login id and password will be provided at the venue only.\n"+
                            "\n"+
                            "4. Is use of internet allowed?\n"+
                            "Ans- Use of the Internet is allowed only in the second round. \n"+
                            "\n"+
                            "5. How we will be informed about our results?\n"+
                            "Ans- The result of rounds will be informed via mail or phone call to the team leader.\n"+
                    "\n"+
                    "6.If there are more than one CEO of the company asked in round 2 . Point will be allotted for one name only?\n"+
                    "Ans- - Yes, if participants answers with any current CEO of the company they will be getting the point.\n ");
        }

        if (getArguments().getInt("index")==4)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. Are Intercollege teams allowed to form team?\n" +""+
                            "Ans-Yes\n"+
                            "\n"+
                            "2. Can we change the domain once its registered?\n"+""+
                            "Ans- No \n"+
                            "\n"+
                            "3. Is it necessary to make the Suicide Squad of 8?\n"+
                            "Ans-Yes\n"+
                            "\n"+
                            "4. What happens if a team of 8 is not made?\n"+
                            "Ans-You will be disqualified.\n"+
                            "\n"+
                            "5.What type of questions will be there in 1st Round?\n"+
                            "Ans- Questions having Common answers."+
            "6. What will happen if the XP is not used? Will they counted as extras?\n"+
            "Ans- No, unused XP will be of no use after the auction. So try to use all the XP\n");
        }

        if (getArguments().getInt("index")==5)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1.Is It compulsory to take part in both rounds?\n" +""+
                            "Ans-No\n"+
                            "\n"+
                            "2. How many pictures can be added to the articles?\n"+""+
                            "Ans-There is no limit.\n"+
                            "\n"+
                    "3.When will the submission of event begin?\n"+
                    "Ans-17th march’18, 12:00 PM.\n"+
                            "\n"+
                    "4. Will there be a separate registration for both the rounds? \n"+
                    "Ans-Yes\n"+
                    "\n"+
                    "5.Will there be separate prizes for both the events?\n"+
                    "Ans-Yes\n"+
                            "6. Do we have to feature ourselves in the after movie?\n" +
                                    "Ans-No compulsion\n"+
                                    "\n"+
                            "7.Will the whole campus be open for this event? \n"+
                                    "Ans-No, Only the portion where e-summit events are going on.\n\n"+
                                    "\n");
        }


        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return view;
    }
}
