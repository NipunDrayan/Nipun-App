package com.example.android.endeavour;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class Main2Activity extends AppCompatActivity
{

    Toolbar myToolbar;
    FrameLayout frameLayout;
    SessionManager sessionManager;
    private static final String BACK_STACK_ROOT_TAG = "root_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar1);
        setSupportActionBar(myToolbar);
        //myToolbar.setTitle("Sponsors");
        sessionManager = new SessionManager(getApplicationContext());
//        final TextView login_link = (TextView) findViewById(R.id.loginlink);
        //      final TextView register_link = (TextView) findViewById(R.id.registerlink);
        frameLayout = (FrameLayout)findViewById(R.id.frame_container);
    /*    login_link.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent loginIntent=new Intent(MainActivity.this,loginActivity.class);
                MainActivity.this.startActivity(loginIntent);
            }
        });

        register_link.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent registerIntent=new Intent(MainActivity.this,RegisterActivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });


    */
        loadFragment1(new Home1Fragment());

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation1);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()
    {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId())
            {
                case R.id.action_home1:
                    fragment = new Home1Fragment();
                    loadFragment(fragment);
                    //setTitle("Home");
                    return true;

                case R.id.action_events:
                    //getActionBar().setTitle("Events");
                    //getActionBar().setTitle("Events");
                    fragment = new EventsFrag();
                    loadFragment(fragment);
                    //setTitle("Events");
                    return true;

                case R.id.action_sponsors:
                    fragment = new Sponsors();
                    loadFragment(fragment);
                    //setTitle("Sponsors");
                    return true;

                case R.id.action_schedules:
                    fragment = new Schedules();
                    loadFragment(fragment);
                    //setTitle("Schedules");
                    return true;

                case R.id.action_contact:
                    fragment = new Contact();
                    loadFragment(fragment);
                    //setTitle("Contact Us");

                            /*case R.id.action_about:
                                myToolbar.setTitle("About Us");
                                fragment = new AboutUs();
                                loadFragment(fragment);
                                return true;*/
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void loadFragment1(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        //transaction.addToBackStack(null);
        transaction.commit();
    }

    public void switchContent(int id,android.app.Fragment fragment)
    {
        FragmentManager fm=getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction=fm.beginTransaction();
        //SettingsFragment fragmentsetting=new SettingFragment();

        fragmentTransaction.replace(id,fragment,fragment.toString());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.androidmain1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_aboutus:
                // User chose the "Settings" item, show the app settings UI...
               /* myToolbar.setTitle("About Us");
                myToolbar.setNavigationIcon(R.mipmap.ic_keyboard_arrow_left_white_36dp);
                myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                    }
                });*/
                Fragment fragment;
                fragment = new AboutUs();
                loadFragment(fragment);
                return true;

            case R.id.action_notification:
                // User chose the "Notification" action, read the current item
                Intent notifyme=new Intent(Main2Activity.this,Notifications.class);
                Main2Activity.this.startActivity(notifyme);
                return true;

            case R.id.action_logout:
                // Clear the session data
                // This will clear all session data and
                // redirect user to MainActivity
                //sessionManager.logoutUser();
                Intent logoutIntent=new Intent(Main2Activity.this,MainActivity.class);
                sessionManager.setLogin(false);
                Main2Activity.this.startActivity(logoutIntent);
                finish();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
