package com.example.thilina.iothack;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by thilina on 11/11/16.
 */
public class FoodAdopter extends RecyclerView.Adapter<FoodAdopter.ViewHolder> {

    private static List<Food> itemList;
    static Context mContext;

    public FoodAdopter(List<Food> myItemList, Context mContext) {
        this.mContext = mContext;
        this.itemList = myItemList;
    }

    @Override
    public FoodAdopter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mImageView.setImageBitmap(itemList.get(position).getImg());
        holder.mImageView2.setImageBitmap(itemList.get(position).getImg2());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{
        public ImageView mImageView;
        public ImageView mImageView2;
        public CardView mCardView;
        public CardView mCardView2;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.fooditem_imageView);
            mImageView2 = (ImageView) itemView.findViewById(R.id.fooditem_imageView2);
            mCardView = (CardView) itemView.findViewById(R.id.food_view);
            mCardView2 = (CardView) itemView.findViewById(R.id.food_view2);
            itemView.setOnClickListener(this);
            mImageView.setOnClickListener(this);
            mCardView.setOnClickListener(this);
            mCardView2.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == mCardView.getId() || v.getId() == mImageView.getId()){
                //Toast.makeText(v.getContext(), "Card1 Pressed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, Waiting.class);
                intent.putExtra("XXX", "SUSHI");
                mContext.startActivity(intent);
            }else if(v.getId() == mCardView2.getId() || v.getId() == mImageView2.getId()){
                Intent intent = new Intent(mContext, Waiting.class);
                intent.putExtra("XXX", "SUSHI");
                mContext.startActivity(intent);
            }
            else {
                //Toast.makeText(v.getContext(), "ROW PRESSED = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public boolean onLongClick(View v) {
            return true;
        }
    }
}
