package com.example.android.endeavour;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by manvi on 10-01-2018.
 */
public class EventPager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public EventPager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                EventsFrag tab1 = new EventsFrag();
                return tab1;
            case 1:
                MyEvents tab2 = new MyEvents();
                return tab2;
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


