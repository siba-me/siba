package com.example.user.siba;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
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
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class FlightDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int NOTIFICATION_REMINDER_NIGHT = 3;
    EditText date,number,time,des;
    TextView t1;
    Button button;
    TimePicker addtime;
    Calendar calendar;

    private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    FirebaseUser currentUser = mAuth.getCurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Users");


        date = (EditText) findViewById(R.id.date);
        number = (EditText) findViewById(R.id.number);
        t1 = (TextView) findViewById(R.id.title);
        button = (Button) findViewById(R.id.button);
        des = (EditText) findViewById(R.id.des);

        addtime = (TimePicker) findViewById(R.id.timePicker);
        addtime.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                int hour = hourOfDay;
                int min = minute;
                calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, hour);
                calendar.set(Calendar.MINUTE, min);
                calendar.set(Calendar.SECOND, 00);


                Intent notifyIntent = new Intent(getApplicationContext(),MyReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast
                        (getApplicationContext(), NOTIFICATION_REMINDER_NIGHT, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,  calendar.getTimeInMillis(),
                        1000 * 60 * 60 * 24, pendingIntent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserFlight userFlight = new UserFlight(date.getText().toString(), number.getText().toString(), "" ,des.getText().toString());
                userFlight.setTimems(calendar.getTimeInMillis());
                Intent i = new Intent(FlightDetailsActivity.this, MyFlights.class);
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

    @Override
    public void onClick(View v) {

    }

//    public void showAlertDialogButtonClicked(View view) {
//
//        // setup the alert builder
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Choose a country");
//
//        // add a radio button list
//        String[] countries = {"Italy", "Spain", "France", "Portugal", "Greece",""};
//        int checkedItem = 1; // cow
//        builder.setSingleChoiceItems(countries, checkedItem, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // user checked an item
//            }
//        });
//
//        // add OK and Cancel buttons
//        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                // user clicked OK
//            }
//        });
//        builder.setNegativeButton("Cancel", null);
//
//        // create and show the alert dialog
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }



    }



