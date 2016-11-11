package com.example.thilina.iothack;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class Waiting extends AppCompatActivity implements SurfaceHolder.Callback{

    TextView mTextView;
    String foodName;

    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3;

    MediaPlayer mediaPlayer;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    Button buttonPlayVideo;
    VideoView mVideoView;
    boolean pausing = false;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);
        Intent intent = getIntent();
        //mTextView = (TextView) findViewById(R.id.test_text);
        foodName = intent.getStringExtra("XXX");
        //mTextView.setText(foodName);

        getWindow().setFormat(PixelFormat.UNKNOWN);

        //Displays a video file.
        mVideoView = (VideoView)findViewById(R.id.videoview);


        String uriPath = "android.resource://com.example.thilina.iothack/"+R.raw.sushi_background;
        Uri uri = Uri.parse(uriPath);
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.start();

        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);

        floatingActionButton1.setColorNormal(getResources().getColor(R.color.colorAccent));
        floatingActionButton2.setColorNormal(getResources().getColor(R.color.colorAccent));
        floatingActionButton3.setColorNormal(getResources().getColor(R.color.colorAccent));

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked
                VideoView mVideoView = (VideoView)findViewById(R.id.videoview);
                String uriPath = "android.resource://com.example.thilina.iothack/"+R.raw.sushi_background;
                Uri uri = Uri.parse(uriPath);
                mVideoView.setVideoURI(uri);
                mVideoView.requestFocus();
                mVideoView.start();
            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                VideoView mVideoView = (VideoView)findViewById(R.id.videoview);
                String uriPath = "android.resource://com.example.thilina.iothack/"+R.raw.sushi_background;
                Uri uri = Uri.parse(uriPath);
                mVideoView.setVideoURI(uri);
                mVideoView.requestFocus();
                mVideoView.start();
            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                VideoView mVideoView = (VideoView)findViewById(R.id.videoview);
                String uriPath = "android.resource://com.example.thilina.iothack/"+R.raw.sushi_background;
                Uri uri = Uri.parse(uriPath);
                mVideoView.setVideoURI(uri);
                mVideoView.requestFocus();
                mVideoView.start();
            }
        });
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
