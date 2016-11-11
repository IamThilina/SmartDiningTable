package com.example.thilina.iothack;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by thilina on 11/11/16.
 */
public class Food {

    private String name;
    private ImageView img;
    private int price;

    public Food(String name, ImageView img, int price){
        this.name = name;
        this.img = img;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public ImageView getImg() {
        return img;
    }
}
