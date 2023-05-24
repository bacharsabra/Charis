package com.example.charis.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Charis.R;
import com.example.charis.Caritas;
import com.example.charis.FoodBlessed;
import com.example.charis.LFB;
import com.example.charis.LLB;
import com.example.charis.WFP;
import com.example.charis.model.Charities;

import java.util.ArrayList;

public class CharityAdapter extends RecyclerView.Adapter<CharityAdapter.PopularViewHolder> {

    private Context context;
    private ArrayList<Charities> charitiesList;

    public CharityAdapter(Context context, ArrayList<Charities> charitiesList) {
        this.context = context;
        this.charitiesList = charitiesList;
    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.popular_recycler_items, parent, false);
        // here we need to create a layout for recyclerview cell items.


        return new PopularViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularViewHolder holder, final int position) {

        holder.popularName.setText(charitiesList.get(position).getName());
        holder.popularImage.setImageResource(charitiesList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:

                        Intent i = new Intent(context, LFB.class);
                        i.putExtra("name", charitiesList.get(position).getName());
                        i.putExtra("date", charitiesList.get(position).getDate());
                        i.putExtra("image", charitiesList.get(position).getImageUrl());

                        context.startActivity(i);
                        break;
                    case 1:

                        Intent i1 = new Intent(context, FoodBlessed.class);
                        i1.putExtra("name", charitiesList.get(position).getName());
                        i1.putExtra("date", charitiesList.get(position).getDate());
                        i1.putExtra("image", charitiesList.get(position).getImageUrl());

                        context.startActivity(i1);
                        break;

                    case 2:

                        Intent i2 = new Intent(context, Caritas.class);
                        i2.putExtra("name", charitiesList.get(position).getName());
                        i2.putExtra("date", charitiesList.get(position).getDate());
                        i2.putExtra("image", charitiesList.get(position).getImageUrl());

                        context.startActivity(i2);
                        break;

                    case 3:

                        Intent i3 = new Intent(context, LLB.class);
                        i3.putExtra("name", charitiesList.get(position).getName());
                        i3.putExtra("date", charitiesList.get(position).getDate());
                        i3.putExtra("image", charitiesList.get(position).getImageUrl());

                        context.startActivity(i3);
                        break;

                    case 4:

                        Intent i4 = new Intent(context, WFP.class);
                        i4.putExtra("name", charitiesList.get(position).getName());
                        i4.putExtra("date", charitiesList.get(position).getDate());
                        i4.putExtra("image", charitiesList.get(position).getImageUrl());

                        context.startActivity(i4);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return charitiesList.size();
    }

    public static class PopularViewHolder extends RecyclerView.ViewHolder {

        ImageView popularImage;
        TextView popularName;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);

            popularName = itemView.findViewById(R.id.all_menu_name);
            popularImage = itemView.findViewById(R.id.all_menu_image);

        }
    }
}
