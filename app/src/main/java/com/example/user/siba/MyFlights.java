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

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

public class MyFlights extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ArrayList<UserFlight> res;
    ArrayAdapter arrayAdapter;
    ListView flist;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_flights);

        String UID = getIntent().getStringExtra("UID");
        String link = "Users/"+UID+"/Flights";
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference(link);

        flist = findViewById(R.id.flist);
        res= new ArrayList<>();
     /*   res.add(new Item(R.drawable.dog,"1"));
        res.add(new Item(R.drawable.dog,"2"));
        res.add(new Item(R.drawable.dog,"3"));
*/
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,res);
        flist.setAdapter(arrayAdapter);

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Map<String, String> map = (Map<String, String>) dataSnapshot.getValue();

                String date = map.get("date");
                String des = map.get("des");
                String number= map.get("number");
                String time = map.get("time");

                res.add(new UserFlight(date, number, time, des));
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


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
