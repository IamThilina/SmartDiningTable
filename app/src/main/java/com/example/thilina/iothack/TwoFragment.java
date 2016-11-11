package com.example.thilina.iothack;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class TwoFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Food> itemList = new ArrayList<>();

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView = (RecyclerView) view.findViewById(R.id.beverages_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new FoodAdopter(itemList, getActivity());
        mRecyclerView.setAdapter(mAdapter);

        setUpData();
    }
    @Override
    public void onStart() {
        Log.d("Fragment Start","Start Fragment");
        super.onStart();
    }

    @Override
    public void onDestroy() {
        Log.d("Freagment Destroyed","Destroy Fragment");
        super.onDestroy();
    }

    @Override
    public void onResume() {
        Log.d("Fragment On Resume", "Resume Fragment");
        super.onResume();
    }

    private void setUpData() {
        itemList.clear();
        itemList.add(new Food(BitmapFactory.decodeResource(getResources(),R.drawable.dr1), BitmapFactory.decodeResource(getResources(),R.drawable.dr2)));
        itemList.add(new Food(BitmapFactory.decodeResource(getResources(),R.drawable.dr3), BitmapFactory.decodeResource(getResources(),R.drawable.dr3)));
        //itemList.add(new Food(BitmapFactory.decodeResource(getResources(),R.drawable.dr5), BitmapFactory.decodeResource(getResources(),R.drawable.dr6)));
        mAdapter.notifyDataSetChanged();
    }
}
