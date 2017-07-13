package com.example.p1colo.layouts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class LayoutsActivity extends AppCompatActivity
    implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setze das Layout für diese Activity: aufblasen
        //setContentView(R.layout.activity_layouts);
        //setContentView(R.layout.meinlinearlayout);
        //setContentView(R.layout.meinrelativelayout);
        setContentView(R.layout.meinspinner);

        //hole das Spinnerelement ab
        //findViewById gibt ein View-Objekt zurück, also Basisklasse aller Views
        //alle Kinder müssen daher down gecasted werden
        Spinner spinner = (Spinner) findViewById(R.id.pizzaspinner);

        //1. fülle den Spinner mit dem String-array aus den Ressourcen
        // wir nutzen das Adapter-Pattern(Muster)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (
                        this,
                        R.array.pizzas,
                        android.R.layout.simple_spinner_item
                );

        spinner.setAdapter(adapter);

        //2. hole einen Listener, der zu dem Spinner passt
        // Listener muss angemeldet werden

        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView ausgabe = (TextView)findViewById(R.id.ausgabe);

        ausgabe.setTextColor(Color.CYAN);

        ausgabe.setText("Sie haben ihr Geld aus dem Fenster geworfen für: "
                 + parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
