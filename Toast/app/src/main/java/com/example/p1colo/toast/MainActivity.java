package com.example.p1colo.toast;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Context context = getApplicationContext(); //this - Activity
        CharSequence text = "Hallo Toast1"; //ausgefeilter String
        int duration = Toast.LENGTH_LONG; //bitte keine eigenen Sekunden

        Toast toast1 = Toast.makeText(context, text, duration);
        toast1.show();

        Toast toast2 = Toast.makeText(this, "Toast 2", Toast.LENGTH_LONG);
        toast2.setGravity(Gravity.TOP | Gravity.LEFT,30,10);
        toast2.show();

        // ---------------- EIGENES TOAST BAUEN ----------------

        LayoutInflater inflater = getLayoutInflater(); //aufblasen

        //hole unser Toastlayout ab
        //inflate (Datei, ...
        View layout = inflater.inflate(R.layout.toast,(ViewGroup)findViewById(R.id.toast_frame));

        //Bilder hier setzen
        ImageView image=(ImageView)layout.findViewById(R.id.toast_image);
        image.setImageResource(R.mipmap.falcon);

        TextView textView = (TextView)layout.findViewById(R.id.toast_text);
        textView.setText("Zzzzzzisch!");

        Toast toast3 = new Toast(context);
        toast3.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast3.setDuration(Toast.LENGTH_LONG);
        toast3.setView(layout);
        toast3.show();





    }
}
