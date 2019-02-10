package com.example.android.endeavour;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TypesCorporateAdapter extends RecyclerView.Adapter<TypesCorporateAdapter.TypeCorporateViewHolder>

    {


        //this context we will use to inflate the layout
        private Context nCtx;

        //we are storing all the products in a list
        private List<TypeCorporate> corporateList;

        //getting the context and product list with constructor
        public TypesCorporateAdapter(Context nCtx, List < TypeCorporate > corporateList) {
        this.nCtx = nCtx;
        this.corporateList = corporateList;
    }

        @Override
        public TypeCorporateViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(nCtx);
        View view = inflater.inflate(R.layout.card_view2, null);
        return new TypeCorporateViewHolder(view);
    }

        @Override
        public void onBindViewHolder (TypeCorporateViewHolder holder,final int position)
        {
        //getting the product of the specified position
        final TypeCorporate corporatevent = corporateList.get(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {

                    Intent intent=new Intent(nCtx,TabMainActivity.class);
                    if(corporatevent.getTitle().equals("Monopoly")) {
                        intent.putExtra("index", 1);
                    }
                    if(corporatevent.getTitle().equals("B-plan")) {
                        intent.putExtra("index", 2);
                    }
                    if(corporatevent.getTitle().equals("Q-fiesta")) {
                        intent.putExtra("index", 3);
                    }
                    if(corporatevent.getTitle().equals("Suicide Squad")) {
                        intent.putExtra("index", 4);
                    }

                    if(corporatevent.getTitle().equals("Your Story")) {
                        intent.putExtra("index", 5);
                    }


                    nCtx.startActivity(intent);}

            });

        //binding the data with the viewholder views
        holder.textViewTitle.setText(corporatevent.getTitle());
            holder.textViewPrice.setText(String.valueOf(corporatevent.getPrice()));
           // holder.textViewPrize.setText(String.valueOf(corporatevent.getPrize()));
        holder.imageView.setImageDrawable(nCtx.getResources().getDrawable(corporatevent.getImage()));
        }


        @Override
        public int getItemCount()
        {
        return corporateList.size();
        }


        class TypeCorporateViewHolder extends RecyclerView.ViewHolder
        {
            TextView textViewTitle;
            TextView textViewPrice;
            ImageView imageView;
            TextView textViewPrize;

            public TypeCorporateViewHolder(View itemView)
            {
                super(itemView);
                textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle1);
                textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);
                //textViewPrize=(TextView) itemView.findViewById(R.id.textViewPrize);
                imageView = (ImageView) itemView.findViewById(R.id.imageView1);

            }
        }
    }

