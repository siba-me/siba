package com.example.user.siba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

public class MyFlights extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    ArrayList<UserFlight> res;
    ArrayAdapter arrayAdapter;
    ListView flist;
    ImageButton btAdd;

    private FirebaseAuth mAuth  = FirebaseAuth.getInstance();
    FirebaseUser user = mAuth.getCurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_flights);

        String UID = user.getUid();
        String link = "Users/"+UID+"/Flights";
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference(link);

        btAdd =(ImageButton) findViewById(R.id.btAdd);
        btAdd.setOnClickListener(this);
        flist = findViewById(R.id.flist);
        res= new ArrayList<>();
        flist.setOnItemClickListener(this);
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

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent i= new Intent(this,MyTrip.class);
        i.putExtra("userFlight", res.get(position));
        startActivity(i);

    }

    @Override
    public void onClick(View v) {
        if(v==btAdd){
            Intent i = new Intent(this,FlightDetailsActivity.class);
            startActivity(i);
        }

    }
}
