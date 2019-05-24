package com.github.oluudeh.recipe.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.oluudeh.recipe.R;
import com.github.oluudeh.recipe.adapter.FoodAdapter;
import com.github.oluudeh.recipe.model.Food;

import org.json.JSONException;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    LinearLayoutManager manager;
    ArrayList<Food> foods;
    FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ActionBar bar = getSupportActionBar();
        if (bar != null)
            bar.setDisplayHomeAsUpEnabled(true);

        setupRecyclerView();
        populate();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("title")) {
            int title = bundle.getInt("title");
            setTitle(title);
        }
    }


    private void setupRecyclerView () {
        recyclerView = findViewById(R.id.recyclerView);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        foods = new ArrayList<>();
        adapter = new FoodAdapter(this, foods);
        recyclerView.setAdapter(adapter);
    }

    private void populate() {
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
            foods.add(food);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            //Intent intent = new Intent(ListActivity.this, MainActivity.class);
            //startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
