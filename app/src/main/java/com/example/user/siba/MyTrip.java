package com.example.user.siba;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MyTrip extends AppCompatActivity {
    TextView des,number,date,time, timeleft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_trip);
        des = findViewById(R.id.des);
        number = findViewById(R.id.number);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        timeleft = findViewById(R.id.tvTimeLeft);

        UserFlight flight = (UserFlight) getIntent().getSerializableExtra("userFlight");
        if(flight != null){
            des.setText("      Destination: " +flight.getDes());
            number.setText("     Flight No.: "+flight.getNumber());
            date.setText("     Date: "+flight.getDate());
            time.setText("    Time: "+flight.getTime());

            Calendar calendar2 = Calendar.getInstance();
            long diff = calendar2.getTimeInMillis() - flight.getTimems();
            long seconds = diff / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;

            timeleft.setText("Time Left: "
                    + diff + " days       "+hours+" hours      "+minutes+"  minutess");
            Toast.makeText(getApplicationContext(), "Diff: "+diff, Toast.LENGTH_LONG).show();

        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    // Menu
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.flight:
                Intent i = new Intent(this,MyFlights.class);
                startActivity(i);
                break;
        }
        switch (item.getItemId()) {
            case R.id.myParking:
                Intent i= new Intent(this,MyParking.class);
                startActivity(i);
                break;
        }
        switch (item.getItemId()) {
            case R.id.res:
                Intent i= new Intent(this,Restaurants.class);
                startActivity(i);
                break;
        }


        return true;

    }

}
