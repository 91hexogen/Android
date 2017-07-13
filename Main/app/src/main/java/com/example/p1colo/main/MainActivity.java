package com.example.p1colo.main;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v = findViewById(R.id.hintergrund);
    }

    public void klickRed (View view){
        v.setBackgroundColor(ContextCompat.getColor(this,R.color.red));
    }

    public void klickGreen (View view){
        v.setBackgroundColor(ContextCompat.getColor(this,R.color.green));
    }

    public void klickBlue (View view){
        v.setBackgroundColor(ContextCompat.getColor(this,R.color.blue));
    }

    public void klickWhite (View view){
        v.setBackgroundColor(ContextCompat.getColor(this,R.color.white));
    }



}
