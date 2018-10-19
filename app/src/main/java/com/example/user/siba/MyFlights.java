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
    ArrayList<String> arrayList= new ArrayList<>();
    ListView flist;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_flights);

        flist= (ListView) findViewById(R.id.flist);


        arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        flist.setAdapter(arrayAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem= arrayList.get(position);
        if (selectedItem=="Germany") {

        }
    }
    @Override
    // Menu
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.airports:
                Toast.makeText(this, "Airports ", Toast.LENGTH_SHORT).show();
                break;
        }
        switch (item.getItemId()) {
            case R.id.flight:
                Toast.makeText(this, "My Flights ", Toast.LENGTH_SHORT).show();
                break;
        }
        switch (item.getItemId()) {
            case R.id.trip:
                Toast.makeText(this, "My trip ", Toast.LENGTH_SHORT).show();
                break;
        }
        switch (item.getItemId()) {
            case R.id.settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
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
