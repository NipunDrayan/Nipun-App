package com.example.android.endeavour;

import android.app.Presentation;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        Log.e("index7",structure.get(getArguments().getInt("index")));

        //Toast.makeText(getContext(),structure.get(getArguments().getInt("index")),Toast.LENGTH_LONG).show();
        if (getArguments().getInt("index")==1) {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n" +
                            "The event is based on MONOPOLY GAME where you will have to buy office accessories. Every team will be provided with virtual money according to which they will buy office accessories.\n"
                            + "\n" +
                            "1. Team Size - maximum 2 members\n" +
                            "2. The event consists of 2 rounds.\n" +
                            "\n" +
                            "Round 1 (CASE STUDY)\n" +
                            "\n" +
                            " " + "- The participants will be given a case study based on entrepreneurship. They have to come up with the appropriate solution for the same. And also what they have learned from the case, with the unique point which is related to entrepreneurship. They have to solve the problem statement given to them in given amount of time.\n" +
                            "\n" +
                            "Round 2 (GAME ROUND)\n" +
                            "\n" +
                            " " + "- 6 team who will qualify round 1 will participate in game round.\n" +
                            "" + "- Game will be held on a gameboard made in volleyball ground.\n" +
                            " " + "-Every team will be given virtual cash.\n" +
                            " " + "- Every member will be participating in this round.\n" +
                            " " + "- All  team leaders will be made to stand on the checkpoints.\n" +
                            " " + "-The team members have to divide the given virtual cash in the way they make their strategy to play the game.\n" +
                            "" + "- The teams will roll the dice to  move forward on given blocks and buy the accessory they land on.\n" +
                            " " + "-Every accessory will have its particular strength depending on its need in office. \n" +
                            " " + "- The strength will be told to the participants at the start of the game round .The players have to decide what to buy on the basis of their intellect and experience.\n" +
                            " " + "-Some blocks will contain random chits which will contain offers for participants. \n" +
                            " " + "-All the teams will be given equal number of throws. \n" +
                            " " + "- The things left unsold in game round will be auctioned.\n" +
                            " " + "-The teams can only use the cash left with them in the game round, no extra cash will be provided to the teams. \n" +
                            " " + "-The auction will be held on the volleyball ground at the place where game round is played.\n");
        }
        if (getArguments().getInt("index")== 2)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n"+"B-PLAN-"+"\n"+
                            "Ideas are abound when you have the conviction to bring about a change around you.The flagship event, B PLAN, lets you promulgate your ground breaking ideas.Showcase your business skills and let the world see your entrepreneurial side.Gear up buddies.Prepare an abstract and be a winner.\n"
                            +"\n"+
                            "STARTUP GRINDx-" +"\n"+"Startup grindx is an actively working startup community linking entrepreneurs from around 140 countries all over the world and acting as a connecting platform for inspiring speakers who share their unbelievable experiences of the corporate world. Endeavour'19 is coming up with the astonishing speakers from the Ghaziabad chapter of Startup Grindx and will create a breathtaking environment motivating the gathering."+"\n\n"+
                            "Fee for B-plan : Rs. 300"+"\n"+
                            "Package- B-plan + Startup grindx : Rs. 550"+"\n"+
                            "Individual for Startup grindx : Rs.150"+"\n"+

                            "1. Team Size - maximum 3 memebers\n" +
                            "2. The event consists of two rounds.\n"+
                            "\n"+
                            "Round 1 (Online Submission- Questionnaire Round:)\n"+
                            "\n"+
                            " "+"-Participants will be given a portal on the website of Endeavour where they will have to fill up the questionnaire round which will consist of several subjective questions based on the different aspects of the startup. Last date of submission:- 20th feb'19\n"
                            + "\n"+
                            "Round 2 Elevator pitching\n"+
                            "\n"+
                             "-It will consist of a timer round where the participant must be able to define their startup within 90 seconds, failing to do so will lead to disqualification.\n"+
                            "Round 3 (Presentation)\n"+
                    "\n"+
                    "-In this round, participants will come with their idea that they have presented before. There will be 5-10 minutes presentation and 2-5 minutes questionnaire round.\n");}
        if (getArguments().getInt("index")==3)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n"+
                            "Which company's mobile phones are marketed with the slogan- Big Inside, Small Outside? Battle it out with the sharpest minds in the form of mind boggling questions and answers."
                            +"\n"+
                            "Team Size - maximum 2 members\n" +
                            "\n"+
                            "The event consists of two rounds.\n"
                            +"\n"+
                            "Round 1- LOGO Quiz(dur:30 min)\n"+
                            "\n"+
                            " "+"- This round is to test your knowledge about the different existing brand.\n"+
                            ""+"- A logo will be given to you and you have to identify the company by the logo. Participants will be judged on their awareness.\n"+
                            "\n"+
                            "Round 2- tell the brands\n" +
                            "\n"+
                            " "+"- In this round ,the clue (logo , hindi translation of their english tagline or vice versa, audio of their advertisement). Will be told to the participants. Then they have to guess the name of the brand. \n"+
                            " "+"10 seconds will be given to answer to each team. \n"+
                            "\n"+
                                    "Round 2- tell us the CEO\n" +
                                    "\n"+
                                    " "+"In round 2 , participants will have to guess the name of CEO and brand names will be given. \n \n");

        }
        if (getArguments().getInt("index")==4)
        {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n"+
                            "Are you a fan of superheroes and wizards? And know how to make a perfect squad. Then come and join us to create your own suicide squad.\n"+
                            "1.Team Size - maximum 2 members\n" +
                            "\n"+
                            "2.The event consists of two rounds.\n"+
                    "\n"+
                            "Round 1:\n"+
                            "\n"+
                            " "+"- It will have 3 domains : Marvel, DC, Harry Potter. Participants can choose any 1 domain and will be required to answer 10 questions out of 15.\n"+
                            "\n"+
                            "Round 2:\n" +
                            "\n"+
                            " "+"- In this round ,participants have to make a squad of 8. They should make their squad in such a way that total power of their squad is highest. The highest one wins.\n");
        }
        if (getArguments().getInt("index")==5) {
            view.setFitsSystemWindows(true);
            ((TextView) view.findViewById(R.id.textView))
                    .setText("\n"+
                            " Are you a writer, photographer or a keen observer, observe  E-summit and send your views on it.\n"+
                            "1.Team Size - 2 member\n" +
                            "\n"+
                            "2.There are two independent rounds in this event.\n"+
                            "\n"+
                            "Sub-Round 1:\n"+
                            "\n"+
                            " "+"-The team has to observe the area near venues and click the photographs.\n"+
                            " "+"-The team has to give an article of 200-300 words regarding our e-summit including photographs.\n"+
                            " "+"-It will be an offline submit with articles and photographs on a paper.\n"+
                            "\n"+
                            "Sub-Round 2:\n"+
                            "\n" +
                            " "+"- If you are good in videography then submit a short video of minimum 2.5 minutes. The last date for submitting is one week after the event. \n"+
                            "\n");
        }

        return view;

    }
}
