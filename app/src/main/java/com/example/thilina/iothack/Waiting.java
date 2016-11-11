package com.example.thilina.iothack;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Waiting extends AppCompatActivity implements SurfaceHolder.Callback, Runnable{

    TextView mTextView;
    String foodName;

    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3;

    MediaPlayer mediaPlayer;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;
    VideoView mVideoView;
    ImageView mImageView;
    Bitmap bmap;
    ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);
        Intent intent = getIntent();
        //mTextView = (TextView) findViewById(R.id.test_text);
        foodName = intent.getStringExtra("XXX");
        //mTextView.setText(foodName);
        mImageView = (ImageView) findViewById(R.id.processingFood);
        getWindow().setFormat(PixelFormat.UNKNOWN);

        Handler uiHandler = new Handler(Looper.getMainLooper());

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
                String uriPath = "android.resource://com.example.thilina.iothack/"+R.raw.sushi_special;
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

        Thread thread = new Thread(this);
        thread.start();
    }

    public void setProcessingFoodImage(String message){
        try {
            Thread.sleep(5000);
            Socket s = new Socket("192.168.8.107", 5000);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(message);

            //read input stream

            DataInputStream dis2 = new DataInputStream(s.getInputStream());

            InputStreamReader disR2 = new InputStreamReader(dis2);
            BufferedReader br = new BufferedReader(disR2);//create a BufferReader object for input
            String encodedImage = br.readLine();
            byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
            bmap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            handler.sendEmptyMessage(0);
            dis2.close();
            s.close();


        } catch (java.lang.Exception exception ) {
            exception.printStackTrace();
        }
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

    @Override
    public void run() {
        setProcessingFoodImage("Order : Sushi");
        while(true){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setProcessingFoodImage("Photo");
        }
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            mImageView.setImageBitmap(bmap);
        }
    };
}
