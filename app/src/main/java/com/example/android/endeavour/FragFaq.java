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
        faq.add("faq6");
        faq.add("faq7");
        faq.add("faq8");
        faq.add("faq9");
        faq.add("faq10");
        faq.add("faq11");



        //Toast.makeText(getActivity(),faq.get(getArguments().getInt("index")),Toast.LENGTH_LONG).show();
        if (getArguments().getInt("index")==1)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. Will  there be any need of stationery?\n" +""+
                            "Ans- No,stationery will be provided at the time of the event.\n"+
                            "\n"+
                            "2. Is there any need of video editing?\n"+""+
                            "Ans- It is up to the participants.\n"+""+
                            "\n"+
                            "3. What will be the size of a logo?\n"+
                            "Ans- Whatever fits in the A4 sheet along with the name.\n");
        }
        if (getArguments().getInt("index")==2)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. Intercollege members are allowed to form a single team?\n"+
                            "Ans- Yes\n"+
                            "\n"+
                            "2. What points must be kept in mind while forming abstract?\n"+""+
                            "Ans- Since abstract is a shorthand representation of your business idea, therefore, it must contain a brief introduction to the main points.\n"+
                            "\n"+
                            "3. What modes can we use for our presentation?\n"+
                            "Ans- The presentation on the final round will be a ppt. There is no need to make any file or a hard copy of your business plan.\n"+
                            "\n"+
                            "4. Can we extend the time limit allotted to us?\n"+
                            "Ans- Extention of the time limit is strictly prohibited, this can lead to negative marking. Your ppt presentation must be finished within the allotted time frame or else your business idea wouldn’t be considered as complete.\n"+
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
                            "Ans- The maximum size of the team is 2 members.A single participant can also represent himself but more than 2 members are not allowed. "+
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
                    "6. How we will be informed about our results?\n"+
                    "Ans- The result of rounds will be informed via mail or phone call to the team leader. ");
        }

        if (getArguments().getInt("index")==4)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. Is there any need for materials regarding players?\n" +""+
                            "Ans- No, everything will be provided at the venue.\n"+
                            "\n"+
                            "2. Can more than one team participate from the same college?\n"+""+
                            "Ans- Yes, more than one team can participate.\n"+
                            "\n"+
                            "3. If two people bid at the same time, who will be counted?\n"+
                            "Ans- This will be decided by the coordinator responsible for biding and his decision will be final.\n"+
                            "\n"+
                            "4. What will be the domain of the quiz?\n"+
                            "Ans- IPL\n"+
                            "\n"+
                            "5. Will extra Points be awarded for not using the match cards?\n"+
                            "Ans- No");
        }

        if (getArguments().getInt("index")==5)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. Is formal dress compulsory for round 4? \n" +""+
                            "Ans- No,it is not compulsory.\n"+
                            "\n"+
                            "2. How many individuals can participate from the same college?\n"+""+
                            "Ans- As many as are interested to participate.\n"+
                            "\n"+
                    "3. Is it allowed to use search engines like Google during board room?\n"+
                    "Ans- No, use of electronic gadgets is prohibited during GD.\n"+
                            "\n"+
                    "4. Which company will be allotted during boardroom?\n"+
                    "Ans- Company will be disclosed at the time of the event.\n"+
                    "\n"+
                    "5. Can the words be changed in 10 minutes?\n"+
                    "Ans- No");
        }

        if (getArguments().getInt("index")==6)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. What type of Problems will be provided?\n" +""+
                            "Ans- Problems regarding startups and their real life implementation \n"+
                            "\n"+
                            "2. What is the minimum number of pages in PDF file?\n"+""+
                            "Ans- There is no minimum only maximum no.of pages and i.e. 4 pages\n"+
                            "\n"+
                            "3. Can we change the startup provided?\n"+
                            "Ans- No.\n"+
                            "\n"+
                            "4. Can we present more than one solutions?\n"+
                            "Ans- No, only the most feasible one should be presented.\n");
        }




        if (getArguments().getInt("index")==7 || getArguments().getInt("index")==8)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. Is It compulsary to take part in both rounds? \n" +""+
                            "Ans- No \n"+
                            "\n"+
                            "2. How many pictures can be added in the articles?\n"+""+
                            "Ans- There is no limit.\n"+
                            "\n"+
                            "3. When will the submission of event begin?\n"+
                            "Ans- 17th march’18, 12:00 PM.\n"+
                            "\n"+
                            "4. Will there be separate registration for both the rounds?\n"+
                            "Ans- Yes\n"+
                            "\n"+
                            "5. Will there be separate prizes for both the events?\n"+
                            "Ans- Yes\n"+
                            "\n"+
                            "6. Do we have to feature ourselves in the aftermovie?\n"+
                            "Ans- No Compulsion\n"+
                            "\n"+
                            "7. Will the whole campus be open for this event?\n"+
                            "Ans- No, Only the portion where e-summit events are going on.\n");
        }

        if (getArguments().getInt("index")==9)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "1. Will there be any need for stationary? \n" +""+
                            "Ans- No, we will provide stationary at the time of the event.\n"+
                            "\n"+
                            "2. What type of kingdom would be provided?\n"+""+
                            "Ans- A virtual kingdom would be provided with all the details of the sectors.\n"+
                            "\n"+
                            "3. What is the art of conquest?\n"+
                            "Ans- It is a simulation based game in which you have to protect your kingdom under different circumstances.\n"+
                            "\n"+
                            "4. Can the distribution of coins be changed after the problem statements begin?\n"+
                            "Ans- No , whats has been done before will be considered final.\n"+
                            "\n"+
                            "5. What will be the judging criteria?\n"+
                            "Ans- Maximum point holder will win.\n");
        }

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return view;
    }
}
