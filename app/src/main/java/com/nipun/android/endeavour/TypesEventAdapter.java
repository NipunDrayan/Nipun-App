package com.example.android.endeavour;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class TypesEventAdapter extends RecyclerView.Adapter<TypesEventAdapter.TypeEventViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;
    Fragment fragment;
    //we are storing all the products in a list
    private List<TypeEvents> eventsList;

    //getting the context and product list with constructor
    public TypesEventAdapter(Context mCtx, List<TypeEvents> eventsList) {
        this.mCtx = mCtx;
        this.eventsList = eventsList;
    }

    @Override
    public TypeEventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_view1, parent,false);
        return new TypeEventViewHolder(view);
    }

    @Override
    public void onBindViewHolder( final TypeEventViewHolder holder, final int position) {
        //getting the product of the specified position
        final TypeEvents eventy = eventsList.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(eventy.getTitle()=="Speakers")
                {
                    mCtx.startActivity(new Intent(mCtx,TedtalkMainActivity.class));
                }
                else if(eventy.getTitle().equals("Corporate Events"))
                {
                    mCtx.startActivity(new Intent(mCtx,corporateActivity1.class));
                }
                else
                {
                    mCtx.startActivity(new Intent(mCtx,hackathonActivity1.class));
                }

            }
        });
        //binding the data with the viewholder views
        holder.textViewTitle.setText(eventy.getTitle());
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(eventy.getImage()));

    }

    private void switchContent(int id,Fragment fm)
    {
        if(mCtx==null)
        {
            return;
        }
        if(mCtx instanceof MainActivity)
        {
            MainActivity mainActivity=(MainActivity) mCtx;
            Fragment frag=fm;
            mainActivity.switchContent(id,frag);
        }
        if(mCtx instanceof Main2Activity)
        {
            Main2Activity mainActivity=(Main2Activity) mCtx;
            Fragment frag=fm;
            mainActivity.switchContent(id,frag);
        }
    }


    @Override
    public int getItemCount() {
        return eventsList.size();
    }


    class TypeEventViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        ImageView imageView;

        public TypeEventViewHolder(View itemView)
        {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

}

