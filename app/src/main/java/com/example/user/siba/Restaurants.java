package com.example.user.siba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Restaurants extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ArrayList<String> arrayList = new ArrayList<>();
    ListView res;
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_flights);

        res = (ListView) findViewById(R.id.flist);

        arrayList.add("CafeCafe");
        arrayList.add("Cafe Joe");
        arrayList.add("KaKao");
        arrayList.add("Schmoozy Tapas Bar");
        arrayList.add("Aroma Espresso bar");
        arrayList.add("Burger Ranch");
        arrayList.add("Segafredo");
        arrayList.add("Pizza hut");
        arrayList.add("La Farina");
        arrayList.add("RedHot");

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        res.setAdapter(arrayAdapter);
        res.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = arrayList.get(position);
        if (selectedItem == "Germany") {

        }
    }
}


