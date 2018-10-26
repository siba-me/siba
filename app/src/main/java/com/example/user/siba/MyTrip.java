package com.example.user.siba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MyTrip extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_trip);
    }
    @Override
    // Menu
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.flight:
                Intent i = new Intent(this,MyFlights.class);
                break;
        }
        switch (item.getItemId()) {
            case R.id.trip:
                Intent i = new Intent(this,MyTrip.class);
                break;
        }
        switch (item.getItemId()) {
            case R.id.myParking:
                Intent i= new Intent(this,MyParking.class);
                break;
        }

        switch (item.getItemId()) {
            case R.id.logout:
                Intent i= new Intent(this,MainActivity.class);
                break;
        }
        return true;

    }

}
