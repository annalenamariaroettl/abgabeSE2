package com.example.myapplication;

import android.util.Log;

import java.io.BufferedReader;

import java.io.DataOutputStream;


import java.io.InputStreamReader;

import java.net.Socket;


public class TCP_Thread extends Thread {
    static Socket clientSocket = null;
    private static final int SERVERPORT = 53212;
    private static final String SERVER = "se2-isys.aau.at";
    private String message;
    private String modifiedSentence;

    TCP_Thread(String text) {
        this.message = text;
    }

    public String getModifiedSentence() {
        return this.modifiedSentence;
    }



    @Override
    public void run() {

        try {
            clientSocket = new Socket(SERVER, SERVERPORT);

            try {
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());// sendet zum Server
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //zurück vom Server
                outToServer.writeBytes(message + "\n"); //als Bytestream senden

                modifiedSentence = inFromServer.readLine();


            } catch (Exception e) {
                Log.e("error",e.toString());

                throw e;

            }  finally {
                if (clientSocket != null) {
                    clientSocket.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
