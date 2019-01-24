package com.example.android.endeavour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by manvi on 18-11-2017.
 */
public class splash extends Activity {


    private ImageView ballon;

    private Animation tran;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ballon =  (ImageView)findViewById(R.id.balloon);

        tran = AnimationUtils.loadAnimation(this, R.anim.fade);

        ballon.setAnimation(tran);

        final Intent one = new Intent(this, MainActivity.class);
        Thread timer=new Thread(){
            public void run(){
                try{
                    sleep(4000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally{
                    startActivity(one);
                    finish();
                }
            }
        };
        timer.start();
    }

}
