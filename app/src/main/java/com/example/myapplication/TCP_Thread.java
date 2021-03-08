package com.example.myapplication;

import android.util.Log;

import java.io.BufferedReader;

import java.io.DataOutputStream;


import java.io.InputStreamReader;

import java.net.Socket;


public class TCP_Thread extends Thread {
    static Socket myClientSocket = null;
    private static final int SERVERPORT = 53212;
    private static final String SERVER = "se2-isys.aau.at";
    private String mymessage;
    private String modifiedSentence;

    TCP_Thread(String text) {
        this.mymessage = text;
    }

    public String getModifiedSentence() {
        return this.modifiedSentence;
    }



    @Override
    public void run() {

        try {
            myClientSocket = new Socket(SERVER, SERVERPORT);

            try {
                DataOutputStream outToServer = new DataOutputStream(myClientSocket.getOutputStream());// sendet zum Server
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(myClientSocket.getInputStream())); //zurück vom Server

                outToServer.writeBytes(mymessage + "\n"); //als Bytestream senden

                modifiedSentence = inFromServer.readLine();


            } catch (Exception myException) {
                Log.e("Fehler",myException.toString());

                throw myException;

            }  finally {

                if (myClientSocket != null) {
                    myClientSocket.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
