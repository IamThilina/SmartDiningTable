package com.example.thilina.iothack;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by asela on 11/11/16.
 */
public class SmartTray {


    public void sendMessage() {
        Thread t = new Thread(){

            @Override
            public void run() {
                try {
                    Socket s = new Socket("192.168.183.1", 7000);
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                    dos.writeUTF("my message");

                    //read input stream

                        DataInputStream dis2 = new DataInputStream(s.getInputStream());

                    InputStreamReader disR2 = new InputStreamReader(dis2);
                    BufferedReader br = new BufferedReader(disR2);//create a BufferReader object for input

                    //print the input to the application screen
//                    final TextView receivedMsg = (TextView) findViewById(R.id.textView2);
//                    receivedMsg.setText(br.toString());

                    dis2.close();
                    s.close();

                } catch (java.lang.Exception exception e) {
                    exception.printStackTrace();
                }
            }
        };
        t.start();
//        Toast.makeText(this, "The message has been sent", Toast.LENGTH_SHORT).show();

    }
}

