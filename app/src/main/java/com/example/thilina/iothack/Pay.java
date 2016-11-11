package com.example.thilina.iothack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Pay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
    }
    public void launchAfterPayed(View view) {
        Intent intent = new Intent(this, AfterPayed.class);
        startActivity(intent);
    }
}
