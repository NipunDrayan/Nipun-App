package com.example.android.endeavour;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

/**
 * Created by manvi on 05-01-2018.
 */
public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;
    int index;
    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount,int index) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
        this.index=index;
        Log.e("index",String.valueOf(index));
    }

    //Overriding method getItem
    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {

            case 0:
                return FragStructure.newInstance(index);
            case 1:
                return FragRules.newInstance(index);
            case 2:
                return FragFaq.newInstance(index);
            /*case 0:
                FragStructure tab1 = new FragStructure();
                return tab1;
            case 1:
                FragRules tab2 = new FragRules();
                return tab2;
            case 2:
                FragFaq tab3 = new FragFaq();
                return tab3;*/
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }

}
