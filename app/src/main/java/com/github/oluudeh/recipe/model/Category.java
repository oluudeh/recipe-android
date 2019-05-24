package com.github.oluudeh.recipe.model;

/**
 * Created by ikay on 8/30/2018.
 */

public class Category {
    private int name;
    private int image;

    public Category(int name, int image) {
        this.setName(name);
        this.setImage(image);
    }


    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
