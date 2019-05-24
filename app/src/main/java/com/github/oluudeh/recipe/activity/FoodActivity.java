package com.github.oluudeh.recipe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.oluudeh.recipe.R;
import com.github.oluudeh.recipe.model.Food;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity implements View.OnClickListener{
    TextView descText, nameText;
    ImageButton prevBtn, nextBtn;
    ArrayList<Integer> images;
    ImageView image;
    int currentImage = 0;
    private Food food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        image = findViewById(R.id.image);
        descText = findViewById(R.id.desc);
        nameText = findViewById(R.id.name);
        nextBtn = findViewById(R.id.nextBtn);
        prevBtn = findViewById(R.id.prevBtn);

        nextBtn.setOnClickListener(this);
        prevBtn.setOnClickListener(this);

        images = new ArrayList<>();
        populateImages();
        image.setImageResource(images.get(currentImage));

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("food")) {
            try {
                food = Food.parse(new JSONObject(bundle.getString("food", "{}")));
                setTitle(food.getName());
                descText.setText(food.getDescription());
                nameText.setText(food.getName());
            }catch (JSONException e){

            }
        }
    }

    @Override
    public void onClick(View view) {
        if (view == prevBtn) {
            prevImage();
        } else if (view == nextBtn) {
            nextImage();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.food_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void populateImages(){
        images.add(R.drawable.s1);
        images.add(R.drawable.s2);
        images.add(R.drawable.s3);
        images.add(R.drawable.s4);
    }

    private void nextImage(){
        currentImage ++;
        if (currentImage >= images.size()) {
            currentImage = 0;
        }
        image.setImageResource(images.get(currentImage));
    }

    private void prevImage(){
        currentImage --;
        if (currentImage < 0) {
            currentImage = images.size() - 1;
        }
        image.setImageResource(images.get(currentImage));
    }

}
