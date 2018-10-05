package com.example.user.siba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FlightDetailsActivity extends AppCompatActivity {
    EditText date,number,time,des,name;
    TextView t1;
    Button button;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);

        date = (EditText) findViewById(R.id.date);
        number = (EditText) findViewById(R.id.number);
        time = (EditText) findViewById(R.id.time);
        des = (EditText) findViewById(R.id.des);
        name = (EditText) findViewById(R.id.name);
        t1 = (TextView) findViewById(R.id.title);
        button = (Button) findViewById(R.id.button);
    }
}
