package com.example.user.siba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Restaurants extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ArrayList<Item> res;
    CustomAdapter arrayAdapter;
    ListView res1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        res1 = findViewById(R.id.res1);
        res= new ArrayList<>();
        res.add(new Item(R.drawable.cafecafe,"Cafe Cafe , Terminal 3, 3rd floor"));
        res.add(new Item(R.drawable.cafejoe,"Cafe Joe, Terminal 3, Departure hall, concourse D"));
        res.add(new Item(R.drawable.kakao,"Kakao, Terminal 3, Arrivals hall"));
        res.add(new Item(R.drawable.aroma,"Aroma Espresso bar , Terminal 3, Departure hall, Gate area"));
        res.add(new Item(R.drawable.burgera,"Burger Ranch , Terminal 3, 3rd floor and Departure hall Food Gate area "));
        res.add(new Item(R.drawable.pizzahut,"Pizza Hut , Terminal 3, 3rd floor and Departure hall Food Gate Area"));
        res.add(new Item(R.drawable.redhot,"Red Hut , Terminal 3, Departure hall, Food Gate Area"));


        arrayAdapter = new CustomAdapter(this,R.layout.custom_row,res);
        res1.setAdapter(arrayAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


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
        switch (item.getItemId()){
            case R.id.res:
                Intent i = new Intent(this,Restaurants.class);
                startActivity(i);
                break;
        }
        switch (item.getItemId()) {
            case R.id.myParking:
                Intent i= new Intent(this,MyParking.class);
                startActivity(i);
                break;
        }

        return true;

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

}


