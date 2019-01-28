package com.example.user.siba;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FlightDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    EditText date,number,time,des;
    TextView t1;
    Button button;

    FirebaseUser currentUser;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Users");
        mAuth = FirebaseAuth.getInstance();

        date = (EditText) findViewById(R.id.date);
        number = (EditText) findViewById(R.id.number);
        time = (EditText) findViewById(R.id.time);
        t1 = (TextView) findViewById(R.id.title);
        button = (Button) findViewById(R.id.button);
        des = (EditText) findViewById(R.id.des);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserFlight userFlight = new UserFlight(date.getText().toString(), number.getText().toString(), time.getText().toString() ,des.getText().toString());
                Intent i = new Intent(FlightDetailsActivity.this, MyTrip.class);
                myRef.child(currentUser.getUid()).child("Flights").push().setValue(userFlight);
                i.putExtra(currentUser.getUid(), "UID");
                startActivity(i);
            }
        });


    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        currentUser = mAuth.getCurrentUser();
    }

    public void showAlertDialogButtonClicked(View view) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose a country");

        // add a radio button list
        String[] countries = {"Italy", "Spain", "France", "Portugal", "Greece",""};
        int checkedItem = 1; // cow
        builder.setSingleChoiceItems(countries, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // user checked an item
            }
        });

        // add OK and Cancel buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // user clicked OK
            }
        });
        builder.setNegativeButton("Cancel", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu,menu);
    return true;
}


    public void onClick(View v) {
        if(v==button){

        }
    }


}
