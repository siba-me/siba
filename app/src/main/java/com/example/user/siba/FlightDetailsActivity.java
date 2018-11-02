package com.example.user.siba;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;

public class FlightDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    EditText date,number,time;
    TextView t1;
    Button button,des;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);
        date = (EditText) findViewById(R.id.date);
        number = (EditText) findViewById(R.id.number);
        time = (EditText) findViewById(R.id.time);
        t1 = (TextView) findViewById(R.id.title);
        button = (Button) findViewById(R.id.button);
        des = (Button) findViewById(R.id.des);
        button.setOnClickListener(this);
        des.setOnClickListener(this);
    }
    public void showAlertDialogButtonClicked(View view) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose a country");

        // add a radio button list
        String[] countries = {"Italy", "Spain", "France", "Portugal", "Greece",""};
        int checkedItem = 1; // cow
        builder.setSingleChoiceItems(countries, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // user checked an item
            }
        });

        // add OK and Cancel buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // user clicked OK
            }
        });
        builder.setNegativeButton("Cancel", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void onClick(View v) {
        if(v==button){
            Intent i = new Intent(this,MyTrip.class);
            startActivity(i);
        }
    }

}
