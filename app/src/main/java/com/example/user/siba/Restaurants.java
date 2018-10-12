package com.example.user.siba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        res.add(new Item(R.id.imageView,"siba"));
        res.add(new Item(R.id.imageView,"siba"));
        res.add(new Item(R.id.imageView,"siba"));

        arrayAdapter = new CustomAdapter(this,R.layout.custom_row,res);
        res1.setAdapter(arrayAdapter);




    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }
}


