package com.github.oluudeh.recipe.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by ikay on 8/30/2018.
 */

public class Food {
    private String name;
    private String description;
    private List<String> ingredients;
    private int image;
    private List<String> tags;
    private String time;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public static Food parse(JSONObject data) throws JSONException {
        Food food = new Food();
        food.setName(data.getString("name"));
        food.setImage(data.getInt("image"));
        food.setDescription(data.getString("description"));
        food.setTime("time");
        return food;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("name", getName());
        obj.put("image", getImage());
        obj.put("description", getDescription());
        obj.put("time", getTime());
        return obj;
    }

    public String toString () {
        try {
            String str = toJSONObject().toString();
            return str;
        }catch (JSONException e){
            return "{}";
        }
    }
}
