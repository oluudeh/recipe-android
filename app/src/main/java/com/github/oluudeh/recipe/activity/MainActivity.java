package com.github.oluudeh.recipe.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.oluudeh.recipe.R;
import com.github.oluudeh.recipe.adapter.CategoryAdapter;
import com.github.oluudeh.recipe.adapter.FeaturedAdapter;
import com.github.oluudeh.recipe.adapter.PopularAdapter;
import com.github.oluudeh.recipe.model.Category;
import com.github.oluudeh.recipe.model.Food;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RecyclerView featuredRecyclerView;
    FeaturedAdapter featuredAdapter;
    LinearLayoutManager featuredManager;
    ArrayList<Food> featuredFoods;

    RecyclerView categoriesRecyclerView;
    CategoryAdapter categoriesAdapter;
    LinearLayoutManager categoriesManager;
    ArrayList<Category> categories;

    RecyclerView popularRecyclerView;
    PopularAdapter popularAdapter;
    LinearLayoutManager popularManager;
    ArrayList<Food> popularFoods;

    TextView popularMore, featuredMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        popularMore = findViewById(R.id.popularMore);
        featuredMore = findViewById(R.id.featuredMore);
        popularMore.setOnClickListener(this);
        featuredMore.setOnClickListener(this);

        setupFeaturedRecyclerView();
        populateFeaturedFoods();

        setupCategoriesRecyclerView();
        populateCategories();

        setupPopularRecyclerView();
        populatePopularFoods();
    }

    @Override
    public void onClick(View view) {
        if (view == popularMore){
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("title", R.string.popular_dishes);
            startActivity(intent);
        } else if (view == featuredMore) {
            Intent intent = new Intent(this, ListActivity.class);
            intent.putExtra("title", R.string.featured_dishes);
            startActivity(intent);
        }
    }

    private void setupFeaturedRecyclerView() {
        featuredRecyclerView = findViewById(R.id.featuredRecyclerView);
        featuredFoods = new ArrayList<>();
        featuredAdapter = new FeaturedAdapter(this, featuredFoods);
        featuredManager = new LinearLayoutManager(this);
        featuredManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        featuredRecyclerView.setAdapter(featuredAdapter);
        featuredRecyclerView.setLayoutManager(featuredManager);
    }

    private void populateFeaturedFoods(){
        for (int i = 0; i < 10; i++) {
            Food food = new Food();
            food.setName("Nice Food " + i + 1);
            food.setDescription("Friend Baked Frog legs are a very delicious delicacies. ...");
            int val = i % 4;
            if (val == 0)
                food.setImage(R.drawable.s1);
            else if (val == 1)
                food.setImage(R.drawable.s2);
            else if (val == 2)
                food.setImage(R.drawable.s3);
            else
                food.setImage(R.drawable.s4);
            featuredFoods.add(food);
        }
        featuredAdapter.notifyDataSetChanged();
    }

    private void setupCategoriesRecyclerView() {
        categoriesRecyclerView = findViewById(R.id.categoriesRecyclerView);
        categories = new ArrayList<>();
        categoriesAdapter = new CategoryAdapter(this, categories);
        categoriesManager = new LinearLayoutManager(this);
        categoriesManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoriesRecyclerView.setAdapter(categoriesAdapter);
        categoriesRecyclerView.setLayoutManager(categoriesManager);
    }

    private void populateCategories(){
        int[] array = new int[]{R.string.breakfast, R.string.dessert, R.string.african, R.string.european, R.string.asian};

        for (int i = 0; i < array.length; i++) {
            int val = i % 4;
            int image;
            if (val == 0)
                image = R.drawable.featured_bg_1;
            else if (val == 1)
                image = R.drawable.featured_bg_2;
            else if (val == 2)
                image = R.drawable.featured_bg_3;
            else
                image = R.drawable.featured_bg_4;

            Category category = new Category(array[i], image);
            categories.add(category);
        }
        categoriesAdapter.notifyDataSetChanged();
    }

    private void setupPopularRecyclerView() {
        popularRecyclerView = findViewById(R.id.popularRecyclerView);
        popularFoods = new ArrayList<>();
        popularAdapter = new PopularAdapter(this, popularFoods);
        popularManager = new LinearLayoutManager(this);
        popularRecyclerView.setAdapter(popularAdapter);
        popularRecyclerView.setLayoutManager(popularManager);
    }

    private void populatePopularFoods(){
        for (int i = 0; i < 7; i++) {
            Food food = new Food();
            food.setName("Nice Food " + i + 1);
            food.setDescription("Baked Frog legs are a very delicious delicacy ...");
            int val = i % 4;
            if (val == 0)
                food.setImage(R.drawable.s1);
            else if (val == 1)
                food.setImage(R.drawable.s2);
            else if (val == 2)
                food.setImage(R.drawable.s3);
            else
                food.setImage(R.drawable.s4);
            popularFoods.add(food);
        }
        popularAdapter.notifyDataSetChanged();
    }

}
