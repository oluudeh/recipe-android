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
import com.github.oluudeh.recipe.activity.ListActivity;
import com.github.oluudeh.recipe.model.Category;

import java.util.ArrayList;

/**
 * Created by ikay on 8/30/2018.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private Context context;
    private ArrayList<Category> categories;

    public CategoryAdapter(Context context, ArrayList<Category> categories){
        this.context = context;
        this.categories = categories;
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_inflater, parent, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Category category = categories.get(position);
        holder.bind(category);
    }

    class CategoryHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView image;
        CategoryHolder(View view){
            super(view);
            title = view.findViewById(R.id.title);
            image = view.findViewById(R.id.image);
        }

        void bind(final Category category){
            title.setText(category.getName());
            image.setImageResource(category.getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ListActivity.class);
                    intent.putExtra("title", category.getName());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

}
