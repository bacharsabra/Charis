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

import com.example.charis.Crackers;
import com.example.charis.Hanis;
import com.example.charis.LFB;
import com.example.Charis.R;
import com.example.charis.Pizzanini;
import com.example.charis.Simit;
import com.example.charis.model.Restaurants;

import java.util.List;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RecommendedViewHolder> {

    private Context context;
    private List<Restaurants> restaurantsList;

    public RestaurantAdapter(Context context, List<Restaurants> restaurantsList) {
        this.context = context;
        this.restaurantsList = restaurantsList;
    }

    @NonNull
    @Override
    public RecommendedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommended_recycler_items, parent, false);
        return new RecommendedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedViewHolder holder, final int position) {

        holder.recommendedName.setText(restaurantsList.get(position).getName());
        holder.recommendedRating.setText(restaurantsList.get(position).getRating());
        holder.recommendedCharges.setText(restaurantsList.get(position).getDeliveryCharges());
        holder.recommendedImage.setImageResource(restaurantsList.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                    Intent i = new Intent(context, Hanis.class);
                    i.putExtra("name", restaurantsList.get(position).getName());
                    i.putExtra("rating", restaurantsList.get(position).getRating());
                    i.putExtra("image", restaurantsList.get(position).getImageUrl());

                    context.startActivity(i);
                    break;

                    case 1:
                        Intent i1 = new Intent(context, Simit.class);
                        i1.putExtra("name", restaurantsList.get(position).getName());
                        i1.putExtra("rating", restaurantsList.get(position).getRating());
                        i1.putExtra("image", restaurantsList.get(position).getImageUrl());

                        context.startActivity(i1);
                        break;

                    case 2:
                        Intent i2 = new Intent(context, Crackers.class);
                        i2.putExtra("name", restaurantsList.get(position).getName());
                        i2.putExtra("rating", restaurantsList.get(position).getRating());
                        i2.putExtra("image", restaurantsList.get(position).getImageUrl());

                        context.startActivity(i2);
                        break;

                    case 3:
                        Intent i3 = new Intent(context, Pizzanini.class);
                        i3.putExtra("name", restaurantsList.get(position).getName());
                        i3.putExtra("rating", restaurantsList.get(position).getRating());
                        i3.putExtra("image", restaurantsList.get(position).getImageUrl());

                        context.startActivity(i3);
                        break;

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantsList.size();
    }

    public static class RecommendedViewHolder extends RecyclerView.ViewHolder{

        ImageView recommendedImage;
        TextView recommendedName, recommendedRating, recommendedCharges;

        public RecommendedViewHolder(@NonNull View itemView) {
            super(itemView);

            recommendedImage = itemView.findViewById(R.id.recommended_image);
            recommendedName = itemView.findViewById(R.id.recommended_name);
            recommendedRating = itemView.findViewById(R.id.recommended_rating);
            recommendedCharges = itemView.findViewById(R.id.delivery_type);
            recommendedCharges = itemView.findViewById(R.id.delivery_type);


        }
    }


}
