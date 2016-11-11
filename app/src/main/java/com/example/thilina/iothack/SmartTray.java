package com.example.thilina.iothack;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by asela on 11/11/16.
 */
public class SmartTray {

    String TAG = "connection";
    public void sendMessage(final String message) {
        Thread t = new Thread(){

            @Override
            public void run() {
                try {
                    Socket s = new Socket("192.168.8.100", 5000);
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                    dos.writeUTF(message);

                    //read input stream

                        DataInputStream dis2 = new DataInputStream(s.getInputStream());

                    InputStreamReader disR2 = new InputStreamReader(dis2);
                    BufferedReader br = new BufferedReader(disR2);//create a BufferReader object for input
                    Log.d(TAG, "recieved message: "+br.readLine());
                    /*
                    * String encodedImage = br.readLine();
                    byte[] decodedString = Base64.decode(encodedImage, Base64.DEFAULT);
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                    Log.d(TAG, "recieved message: "+encodedImage);
                    mImageView.setImageBitmap(decodedByte);
                    */
                    //print the input to the application screen
//                    final TextView receivedMsg = (TextView) findViewById(R.id.textView2);
//                    receivedMsg.setText(br.toString());

                    dis2.close();
                    s.close();


                } catch (java.lang.Exception exception ) {
                    exception.printStackTrace();
                    Log.d(TAG, "Error:"+exception);
                }
            }
        };
        t.start();
        Log.d(TAG, "message sent succesfully");
//        Toast.makeText(this, "The message has been sent", Toast.LENGTH_SHORT).show();

    }
}

