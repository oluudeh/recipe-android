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

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder> {

    private Context context;
    private ArrayList<Food> foods;

    public FoodAdapter(Context context, ArrayList<Food> foods) {
        this.context = context;
        this.foods = foods;
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.food_inflater, parent, false);
        return new FoodHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, int position) {
        Food food = foods.get(position);
        holder.bind(food);
    }


    class FoodHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title, desc, moreBtn;
        View view;
        FoodHolder(View view) {
            super(view);
            this.view = view;
            image = view.findViewById(R.id.image);
            title = view.findViewById(R.id.title);
            desc = view.findViewById(R.id.desc);
            moreBtn = view.findViewById(R.id.moreBtn);
        }

        void bind(final Food food){
            image.setImageResource(food.getImage());
            title.setText(food.getName());
            desc.setText(food.getDescription());
            moreBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, FoodActivity.class);
                    intent.putExtra("food", food.toString());
                    context.startActivity(intent);
                }
            });
        }
    }
}
