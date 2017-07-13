package com.example.p1colo.malen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MalenView malenView = new MalenView(getApplicationContext());

        setContentView(malenView);
    }
}
