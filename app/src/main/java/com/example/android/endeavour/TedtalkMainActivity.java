package com.example.android.endeavour;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TedtalkMainActivity extends AppCompatActivity
{

    ViewPager viewPager;
    RequestQueue rq;
    List<SlideUtils> sliderImg;
    ViewPagerAdapter viewPagerAdapter;
    String request_url="http://endeavourkiet.in/app17/speakers.php";
    LinearLayout sliderDotsPanel;
    private int dotscount;
    private ImageView [] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tedtalk_main);

        rq= Volley.newRequestQueue(this);
        sliderImg=new ArrayList<>();

        viewPager =(ViewPager)findViewById(R.id.viewpager);
        sliderDotsPanel=(LinearLayout)findViewById(R.id.SliderDots);

        sendRequest();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                for(int i=0; i<dotscount;i++)
                {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
                }
                dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

        Timer timer= new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);
    }


    public class MyTimerTask extends TimerTask
    {
        @Override
        public void run() {
            TedtalkMainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {


                    if (viewPager.getCurrentItem() == 0)
                        viewPager.setCurrentItem(1);
                    else if (viewPager.getCurrentItem() == 1)
                        viewPager.setCurrentItem(2);
                    else if (viewPager.getCurrentItem() == 2)
                        viewPager.setCurrentItem(3);
                    else if (viewPager.getCurrentItem() == 3)
                        viewPager.setCurrentItem(4);
                    else if (viewPager.getCurrentItem() == 4)
                        viewPager.setCurrentItem(5);
                    else if (viewPager.getCurrentItem() == 5)
                        viewPager.setCurrentItem(6);
                    else
                        viewPager.setCurrentItem(0);
                }
            });

        }
    }

    public void sendRequest()
    {
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, request_url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++)
                {
                    SlideUtils slideUtils=new SlideUtils();
                    try {
                        JSONObject jsonObject=response.getJSONObject(i);
                        //take from json data with image_url option.
                        slideUtils.setSliderImageUrl(jsonObject.getString("image_url"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    sliderImg.add(slideUtils);
                }
                viewPagerAdapter=new ViewPagerAdapter(sliderImg,TedtalkMainActivity.this);
                viewPager.setAdapter(viewPagerAdapter);

                dotscount =viewPagerAdapter.getCount();
                dots=new ImageView[dotscount];
                 for(int i=0; i<dotscount;i++)
                 {
                     dots[i]=new ImageView(TedtalkMainActivity.this);

                     dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));

                     LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                             params.setMargins(8 , 0 ,8 , 0);
                     sliderDotsPanel.addView(dots[i],params);
                 }

                dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        rq.add(jsonArrayRequest);
    }

}
