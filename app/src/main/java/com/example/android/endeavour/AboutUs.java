package com.example.android.endeavour;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUs extends Fragment {


    public AboutUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        ImageButton fb = (ImageButton) view.findViewById(R.id.fb);
        ImageButton insta = (ImageButton) view.findViewById(R.id.insta);
        ImageButton twitt = (ImageButton) view.findViewById(R.id.twitt);
        ImageButton you = (ImageButton) view.findViewById(R.id.you);
        fb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String path = "http://www.facebook.com/endeavourkiet";
                String scheme = "fb://facewebmodal/f?href=" + path;
                String nomPackageInfo = "com.facebook.katana";
                try
                {
                    int vc = getActivity().getPackageManager().getPackageInfo(nomPackageInfo, 0).versionCode;
                    if (vc >= 3002850)
                    {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(scheme));
                        getActivity().startActivity(intent);
                    }
                    else
                    {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/897186340311828"));
                        getActivity().startActivity(intent);
                    }
                }
                catch (Exception e)
                {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(path));
                    getActivity().startActivity(intent);
                }

                /*Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/endeavourkiet"));
                startActivity(browserIntent);*/
            }
        });
        insta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String scheme = "http://instagram.com/_u/endeavourkiet";
                String path = "https://instagram.com/endeavourkiet";
                String nomPackageInfo = "com.instagram.android";
                try {
                    getActivity().getPackageManager().getPackageInfo(nomPackageInfo, 0);
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(scheme));
                    getActivity().startActivity(intent);
                } catch (Exception e) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(path));
                    getActivity().startActivity(intent);
                }
            }
        });
        twitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                String scheme = "twitter://user?screen_name=ecellkiet";
                String path = "https://twitter.com/#!/ecellkiet";
                String nomPackageInfo = "com.twitter.android";
                try {
                    // get the Twitter app if possible
                    getActivity().getPackageManager().getPackageInfo(nomPackageInfo, 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(scheme));
                    getActivity().startActivity(intent);
                } catch (Exception e) {
                    // no Twitter app, revert to browser
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(path));
                    getActivity().startActivity(intent);
                }
            }
        });
        you.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                String scheme = "https://www.youtube.com/channel/UCpKWoJOSPr3rxTbPHx_kbaw";
                String path = "https://www.youtube.com/channel/UCpKWoJOSPr3rxTbPHx_kbaw";
                String nomPackageInfo = "com.google.android.youtube";
                try {
                    // get the Twitter app if possible
                    getActivity().getPackageManager().getPackageInfo(nomPackageInfo, 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(scheme));
                    getActivity().startActivity(intent);
                } catch (Exception e) {
                    // no Twitter app, revert to browser
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(path));
                    getActivity().startActivity(intent);
                }
            }
        });
        return view;
    }

}