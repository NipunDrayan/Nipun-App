package com.example.android.endeavour;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
/**
 * A simple {@link Fragment} subclass.
 */
public class Sponsors extends Fragment
{

    ImageView imageView;
    String server_url = "http://endeavourkiet.in/app17/SPONSORS.jpg";
    ProgressDialog mProgressDialog;
    android.support.v4.app.FragmentManager fragmentManager;

    public Sponsors()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sponsors, container, false);
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setMessage("Loading !!!!");

        imageView = (ImageView) view.findViewById(R.id.imgsp);
        mProgressDialog.show();
        ImageRequest imageRequest = new ImageRequest(server_url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response)
            {
                Log.e("response",String.valueOf(response));
                imageView.setImageBitmap(response);
                mProgressDialog.dismiss();
            }
        },0,0, ImageView.ScaleType.CENTER_CROP,null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("Error",String.valueOf(error));

                Toast.makeText(getContext(),"Error while Loading...",Toast.LENGTH_LONG).show();
                mProgressDialog.dismiss();
             /*   Home homeFragment = new Home();
                fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().setCustomAnimations(R.anim.slidein, R.anim.slideout).replace(R.id.frame_container,homeFragment).commit();
*/

            }
        });
        MySingleton.getInstance(getContext()).addToRequestQueue(imageRequest);
        return view;
    }
}
