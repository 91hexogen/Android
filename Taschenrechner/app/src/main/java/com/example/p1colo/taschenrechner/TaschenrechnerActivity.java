package com.example.p1colo.taschenrechner;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TaschenrechnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taschenrechner);
    }
}

class ButtonClickListener implements DialogInterface.OnClickListener {

    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
}

