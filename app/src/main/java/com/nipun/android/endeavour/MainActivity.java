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

public class MainActivity extends AppCompatActivity
{
    Toolbar myToolbar;
    SessionManager sessionManager;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
       // startActivity(new Intent(this,Main2Activity.class));
        //myToolbar.setTitle("Sponsors");


       // Log.e()
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



 loadFragment(new Home());
    */
        sessionManager = new SessionManager(getApplicationContext());
        if(sessionManager.isLoggedIn())
        {
            startActivity(new Intent(MainActivity.this,Main2Activity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

            finish();
        }
        loadFragment1(new Home());
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
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
                            case R.id.action_home:
                                //getActionBar().setTitle("Home");
                                fragment = new Home();
                                loadFragment(fragment);


                                return true;
                            case R.id.action_events:
                                //getActionBar().setTitle("Events");
                                fragment = new EventsFrag();
                                loadFragment(fragment);

                                return true;
                            case R.id.action_sponsors:
                                //getActionBar().setTitle("Sponsors");
                             fragment = new Sponsors();
                                loadFragment(fragment);
                               /* setTitle("Sponsors");
                                myToolbar.setNavigationIcon(R.mipmap.ic_keyboard_arrow_left_white_36dp);
                                myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    }
                                });*/
                                return true;
                            case R.id.action_schedules:
                                //getActionBar().setTitle("Schedules");
                                fragment = new Schedules();
                                loadFragment(fragment);

                                return true;
                            case R.id.action_contact:
                                //getActionBar().setTitle("Contact Us");
                                fragment = new Contact();
                                loadFragment(fragment);
                                return true;
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
       // transaction.addToBackStack(null);
        transaction.commit();
    }

    public void switchContent(int id,android.app.Fragment fragment)
    {
        FragmentManager fm=getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction=fm.beginTransaction();
        //SettingsFragment fragmentsetting=new SettingFragment();

        fragmentTransaction.replace(id,fragment,fragment.toString());
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.androidmain,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_aboutus:
                // User chose the "Settings" item, show the app settings UI...
               /* myToolbar.setNavigationIcon(R.mipmap.ic_keyboard_arrow_left_white_36dp);
                myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    }
                });*/
                Fragment fragment;
                fragment = new AboutUs();
                loadFragment(fragment);
                return true;

            case R.id.action_notification:
                // User chose the "Notification" action, read the current item
                Intent notifyme=new Intent(MainActivity.this,Notifications.class);
                MainActivity.this.startActivity(notifyme);
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


  /*  @Override
    public void onBackPressed()
    {
        if (getFragmentManager().getBackStackEntryCount() == 0)
        {
            this.finish();
        }
        else
        {
            getFragmentManager().popBackStack();
        }
    }
*/
}
