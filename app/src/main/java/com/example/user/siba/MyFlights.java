package com.example.user.siba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyFlights extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<Item> res;
    CustomAdapter arrayAdapter;
    ListView flist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_flights);

        flist = findViewById(R.id.flist);
        res= new ArrayList<>();
        res.add(new Item(R.drawable.dog,"1"));
        res.add(new Item(R.drawable.dog,"2"));
        res.add(new Item(R.drawable.dog,"3"));

        arrayAdapter = new CustomAdapter(this,R.layout.custom_row,res);
        flist.setAdapter(arrayAdapter);

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
            case R.id.trip:
               Intent i = new Intent(this,MyTrip.class);
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
        switch (item.getItemId()) {
            case R.id.Fdetails:
                Intent i= new Intent(this,FlightDetailsActivity.class);
                startActivity(i);
                break;
        }

        switch (item.getItemId()) {
            case R.id.logout:
                Intent i= new Intent(this,MainActivity.class);
                startActivity(i);
                break;
        }
        return true;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
