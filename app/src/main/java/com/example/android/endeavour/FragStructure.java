package com.example.android.endeavour;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manvi on 04-01-2018.
 */

/**
 * Created by manvi on 04-01-2018.
 */
public class FragStructure extends Fragment {

    public static FragStructure newInstance(int index) {
        Bundle args = new Bundle();
        args.putInt("index", index);
        //Log.e("index3",String.valueOf(index));
        FragStructure fragment = new FragStructure();
        fragment.setArguments(args);
        return fragment;
    }
    View view;

    List<String> structure=new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.structure,container,false);

        //// CREATE LIST DATA ///////
        structure.add("Structure1");
        structure.add("Structure2");
        structure.add("Structure3");
        structure.add("Structure4");
        structure.add("Structure5");
        structure.add("Structure6");
        structure.add("Structure7");
        structure.add("Structure8");
        structure.add("Structure9");
        structure.add("Structure10");
        structure.add("Structure11");
        Log.e("index7",structure.get(getArguments().getInt("index")));

        //Toast.makeText(getContext(),structure.get(getArguments().getInt("index")),Toast.LENGTH_LONG).show();
        if (getArguments().getInt("index")==1)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                        .setText("\n"+
                                "If you have a dream to set a Business or a new Product, then this is for you . In this event you will experience the live start up challenges.\n"
                                +"\n"+
                                "1. Team Size - maximum 3 memebers\n" +
                                "2. The event consists of two rounds.\n"+
                                "\n"+
                                "Round 1\n"+
                                "\n"+
                                " "+"- Theme  is decided by lucky draw method.\n" +
                                " "+"- Then particular theme is given to each team  for e.g. machine learning , then they have to planned startup related to this field.\n"+
                                " "+"- Start up challenge is divided into some tasks.\n"+
                                "\n"+
                                "- "+""+"1- Poster Presntation of a plan.\n" +
                                "\n"+"-"+""+"\tIt must include:" +
                                "\n"+"-"+"\t\tproblem statement" +
                                "\n"+"-"+"\t\tsolution" +
                                "\n"+"-"+"\t\tstructured plan"+
                                "- "+""+"2- Design a logo along with the company name on an A4 sheet.\n" +
                                "- "+""+"3- Make an advertisement video of minimum 30 seconds.( The  video will be submitted on the same day of event)\n"+
                                "\n"+
                                "Round 2\n"+
                                "\n"+
                                " Each team will represent their plan in front of the judges.\n" +
                                " The presentation will be of 5-10 minutes and 2-5 minutes will be for cross-questioning. \n");

        }
        if (getArguments().getInt("index")== 2)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n"+
                            "Ideas are abound when you have the conviction to bring about a change around you.The flagship event, B PLAN, lets you promulgate your ground breaking ideas.Showcase your business skills and let the world see your entrepreneurial side.Gear up buddies.Prepare an abstract and show it and be a winner.\n"
                            +"\n"+
                            "1. Team Size - maximum 3 memebers\n" +
                            "2. The event consists of three rounds.\n"+
                            "\n"+
                            "Round 1 (Online Submission- Questionnaire Round:)\n"+
                            "\n"+
                            " "+"- Participants will be given the portal on the website of Endeavour where they will have to answer the questionnaire round which will consist of several subjectives questions based on the different aspects of the startup.\n"+
                            "Round 2 (Presentation)\n"+
                            "\n"+
                             "- In this, participants will come with a PPT to present their idea. There will be 5-10 minutes of presentation and 2-5 minutes of questionnaire round.\n"+
                            "- The points to be involved in the presentation involve the following:\n"+
                            "•\tTopic of your plan\n"+
                            "•\tDescription of your company, including your products and/or services \n"+
                            "•\tMission statement\n"+
                            "•\tMarket analysis\n"+
                            "•\tSales and marketing model\n"+
                            "•\tRevenue model\n"+
                            "•\tConclusion\n");
        }
        if (getArguments().getInt("index")==3)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n"+
                            "Which company's mobile phones are marketed with the slogan- Big Inside, Small Outside? Battle it out with the sharpest minds in the form of mind boggling questions and answers."
                            +"\n"+
                            "Team Size - maximum 2 memebers\n" +
                            "\n"+
                            "The event consists of two rounds.\n"
                            +"\n"+
                            "Round 1- Online Quiz(dur:30 min)\n"+
                            "\n"+
                            " "+"- There will be an online quiz.\n"+
                            ""+"- There will be 30 questions in this round.\n"+
                            " " +"-Hints will be provided for some questions.\n"+
                            " "+"- Username and password will be provided on the day of quiz.\n"+
                            "\n"+
                            "Round 2- Google Quiz(dur:60 min)\n" +
                            "\n"+
                            " "+"- Google search is allowed in this round.\n"+
                            " "+"- There will be 20 questions for 60 minutes.\n");

        }
        if (getArguments().getInt("index")==4)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n"+
                            "This event is based on IPL auction where you have to make a team of 11 players. Every team will be provided with points according to which an auction will be organized.\n"+
                            "1.Team Size - maximum 2 memebers\n" +
                            "\n"+
                            "2.The event consists of two rounds.\n"+
                    "\n"+
                            "Round 1- Online Quiz(dur:30 min)\n"+
                            "\n"+
                            " "+"- An online quiz will be conducted.\n"+
                            ""+"- There will be 30 questions in this round.\n"+
                            " "+"- Username and password will be provided on the day of quiz.\n"+
                            "\n"+
                            "Round 2- Auction Round\n" +
                            "\n"+
                            " "+"- Every team would be given 100 points.\n"+
                    " "+"- Teams will have to make a 11 member team in the auction.\n"+
                    " "+"- Every team would get 2 Match card.They can use the match card in the auction.\n"+
                    " "+"- Match card provides the team the right to but the player at minimum cost.");
        }
        if (getArguments().getInt("index")==5) {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n"+
                            " Test yourself on a wide range of skills starting from finance, management right up to marketing and entrepreneurship. Challenge your competitors and be the ruler of your destiny. \n"+
                            "1.Team Size - 1 memeber\n" +
                            "\n"+
                            "2.The event consists of four rounds.\n"+
                            "\n"+
                            "Round 1- Questionaire Round\n"+
                            "\n"+
                            " "+"- A questionaire will be provided to the participants prior to the event.\n"+
                            "\n"+
                            "Round 2- Board Room\n"+
                            "\n" +
                            " "+"- The shortlisted participant will compete the in the board room at the venue.\n"+
                            "\n"+
                            "Round 3- 10 Minutes Round\n"+
                            "\n"+
                            " "+"- Participants will be provided 'chits' and on the basis of these chits, participants will have to propose a business plan.\n"+
                            "Round 4- Personal Interview\n"+
                            "\n"+
                            " "+ "- The selected participants will go through a personal interview round with a panel of judges.Only one will come out with the tag of BEST MANAGER");
        }
        if (getArguments().getInt("index")==6) {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n"+
                            "Explore the world of startups, learn from the failures  and propose a better solution and get a chance to work on it.\n"+
                            "1. Team Size - maximum 2 memebers\n" +
                            "\n"+
                            "2. The event consists of two rounds.\n" +
                            "\n"+
                            "3. A failed startup will be provided to the participants in the form of .pdf file after few days of registration.\n"+
                            "\n"+
                            "Round 1- Online Submission/Screening Round\n" +
                            "\n"+
                            " "+"- We will send  any startup to the participating team, and the team has to send the SWOT analysis of startup related to that theme.\n"+
                            " "+"- The team has to send a .pdf file of the SWOT analysis.\n"+
                            " "+"-Pdf file must contain:-\n"+
                            " "+"- A. First page.\n"+
                            " "+"- B. Name of the startup.\n"+
                            " "+ "- C. Team name\n"+
                            " "+ "- D. Contact details of team member.\n"+
                            " "+"- E.Note:-The .pdf file must not exceed 4 pages.\n"+
                            "\n"+
                            "Round 2- In this round, the shortlisted participant will get a problem statement on the spot. They have to find the solution for the same and present it in front of the judges in 5 minutes.\n.");
        }
        if (getArguments().getInt("index")==7 || getArguments().getInt("index")==8)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n"+
                            " Are you a writer, photographer or a keen observer, observe E-summit and send your views on it.\n"+
                            "1. Team Size - maximum 2 memebers\n" +
                            "\n"+
                            "2. There are two independent rounds in this event.\n" +
                            "\n"+
                            "EVENT NO-1\n" +
                            "\n"+
                            " "+"- The team has to observe the area near venues and has to click the photographs.\n"+
                            " "+"-The team has to give an article of 200-300 words regarding our e-summit including photographs.\n"+
                            " "+"-There will be an online submission with articles and photographs. The last date for submitting is 3 days after the event.\n"+
                            "\n"+
                            "EVENT NO-2\n"+
                            "\n"+
                            ""+"-If You are good in videography then submit a short video of minimum 1.5 minutes. The last date for submitting is 3 days after the event.\n.");
        }
        if (getArguments().getInt("index")==9) {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n"+
                            "So you want to make strategy? You want to be an Emperor of a kingdom and make interesting decisions. Be here and enjoy the culture of conquest."+
                            "\n"+
                            "1. Team Size - maximum 2 memebers\n" +
                            "\n"+
                            "2. The event consists of one round.\n" +
                            "\n"+
                            "Round 1\n" +
                            "\n"+
                            " "+"- Team would be given 100 coins to distribute among different sectors.\n"+
                            " "+"- A kingdom will be given and the team has to invest in the different aspects. \n"+
                            " "+"- At regular intervals different situation would be given regarding the sector. \n"+
                            " "+"The team has to make right decision to protect their kingdom and to minimize the loss.\n");
        }
        return view;

    }
}
