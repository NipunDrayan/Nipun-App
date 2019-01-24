package com.example.android.endeavour;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;

import java.util.List;

/**
 * Created by manvi on 09-01-2018.
 */
public class ViewPagerAdapter extends PagerAdapter
{
    private Context context;
    private LayoutInflater layoutInflater;
    private List<SlideUtils> sliderImg;
    private ImageLoader imageLoader;
    //private Integer images[]={R.drawable.logoendeavour,R.drawable.logoendeavour,R.drawable.logoendeavour};
    public ViewPagerAdapter(List<SlideUtils> sliderImg,Context context)
    {
        this.sliderImg=sliderImg;
        this.context=context;
    }

    @Override
    public int getCount() {
        return sliderImg.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public Object instantiateItem(ViewGroup container, final int position)
    {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.custom_layout,null);
        SlideUtils utils=sliderImg.get(position);

        ImageView imageView=(ImageView)view.findViewById(R.id.imageView);
       // imageView.setImageResource(images[position]);

        imageLoader =CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(utils.getSliderImageUrl(),ImageLoader.getImageListener(imageView,R.mipmap.ic_launcher,android.R.drawable.ic_dialog_alert));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0)
                    Toast.makeText(context,"Slide 1 Clicked",Toast.LENGTH_SHORT).show();
                else if(position==1)
                    Toast.makeText(context,"Slide 2 Clicked",Toast.LENGTH_SHORT).show();
                else if(position==2)
                    Toast.makeText(context,"Slide 3 Clicked",Toast.LENGTH_SHORT).show();
                else if(position==3)
                    Toast.makeText(context,"Slide 4 Clicked",Toast.LENGTH_SHORT).show();
                else if(position==4)
                    Toast.makeText(context,"Slide 5 Clicked",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context,"Slide 6 Clicked",Toast.LENGTH_SHORT).show();
            }
        });
        ViewPager vp=(ViewPager)container;
        vp.addView(view,0);
        return view;
    }

    public void destroyItem(ViewGroup container,int position,Object object)
    {
        ViewPager vp=(ViewPager)container;
        View view = (View)object;
        vp.removeView(view);
    }

}
