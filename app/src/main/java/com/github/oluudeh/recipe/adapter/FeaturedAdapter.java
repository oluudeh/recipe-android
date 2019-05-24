package com.github.oluudeh.recipe.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.oluudeh.recipe.R;
import com.github.oluudeh.recipe.activity.FoodActivity;
import com.github.oluudeh.recipe.model.Food;

import java.util.ArrayList;


/**
 * Created by ikay on 8/30/2018.
 */

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedHolder> {

    ArrayList<Food> foods;
    Context context;

    public FeaturedAdapter(Context context, ArrayList<Food> foods) {
        this.foods = foods;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    @NonNull
    @Override
    public FeaturedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.featured_inflater, parent, false);
        return new FeaturedHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedHolder holder, int position) {
        Food food = foods.get(position);
        holder.bind(food);
    }

    class FeaturedHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title, details;
        View view;

         FeaturedHolder(View v){
            super(v);
            this.view = v;
            image = v.findViewById(R.id.image);
            title = v.findViewById(R.id.title);
            details = v.findViewById(R.id.details);
        }

        void bind(final Food food){
            //int val = position % 4;
            /*if (val == 0){
                view.setBackgroundResource(R.drawable.featured_bg_1);
            }else if (val == 1) {
                view.setBackgroundResource(R.drawable.featured_bg_2);
            }else if (val == 2) {
                view.setBackgroundResource(R.drawable.featured_bg_3);
            } else {
                view.setBackgroundResource(R.drawable.featured_bg_4);
            }*/
            title.setText(food.getName());
            image.setImageResource(food.getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FoodActivity.class);
                    intent.putExtra("food", food.toString());
                    context.startActivity(intent);

                }
            });
        }

    }
}
