package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.myapplication.R.id.myNumber;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView text;
    private TextView matrikelnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= findViewById(R.id.button);
        text= findViewById(R.id.textView);
        matrikelnumber= findViewById(R.id.myNumber);


       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });


    }
}