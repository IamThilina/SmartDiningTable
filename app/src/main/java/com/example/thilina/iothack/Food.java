package com.example.thilina.iothack;

import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;

/**
 * Created by thilina on 11/11/16.
 */
public class Food {

    //private String name;
    private Bitmap img;
    private Bitmap img2;

    public Food(Bitmap img, Bitmap img2){
        //this.name = name;
        this.img = img;
        this.img2 = img2;
        //this.price = price;
    }

    public Bitmap getImg() {
        return img;
    }

    public Bitmap getImg2() {
        return img2;
    }
}
