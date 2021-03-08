package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView matrikelnumber;
    private TextView antwortServer;
    private String matrikel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= findViewById(R.id.button);
        
        matrikelnumber= findViewById(R.id.myNumber);
        antwortServer= findViewById(R.id.serverAntwort);


       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

             String result;

                   matrikel= matrikelnumber.getText().toString();

                   char[]myChar=matrikel.toCharArray();

                   for(int i =0; i< myChar.length; i++) {
                       if (i % 2 != 0) {
                           switch (myChar[i]) {
                               case '1':
                                 myChar[i]='a';
                                 break;
                               case '2':
                                 myChar[i]='b';
                                 break;
                               case '3':
                                  myChar[i]='c';
                                  break;
                               case '4':
                                   myChar[i]='d';
                                   break;
                               case '5':
                                   myChar[i]='e';
                                   break;
                               case '6':
                                   myChar[i]='f';
                                   break;
                               case '7':
                                   myChar[i]='g';
                                   break;
                               case '8':
                                   myChar[i]='h';
                                   break;
                               case '9':
                                   myChar[i]='i';
                                   break;
                               case '0':
                                   myChar[i]='j';
                                   break;
                               
                               
                           }

                       }


                   }

                   result= new String(myChar);

                    antwortServer.setText(result);

           }
       });

        }

        public void sendMessage(View v){

                  matrikel = matrikelnumber.getText().toString();


                  try {
                      TCP_Thread thread = new TCP_Thread(matrikel);
                      thread.start(); //start runnable


                      thread.join(); //wartet bis der task im tcp thread  fertig ist 

                      antwortServer.setText(thread.getModifiedSentence());

                  } catch (Exception myException) {

                      antwortServer.setText(myException.toString());
                  }






        }


    }
