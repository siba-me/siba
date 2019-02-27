package com.example.user.siba;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button signIn,signUp;
    private static final int NOTIFICATION_REMINDER_NIGHT = 3;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            signIn = (Button) findViewById(R.id.MsignIn);
            signUp = (Button) findViewById(R.id.MsignUp);
            signUp.setOnClickListener(this);
            signIn.setOnClickListener(this);
            Intent notifyIntent = new Intent(this,MyReceiver.class);

            PendingIntent pendingIntent = PendingIntent.getBroadcast

                    (this, NOTIFICATION_REMINDER_NIGHT, notifyIntent,
                            PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmManager alarmManager = (AlarmManager) this.getSystemService(this.ALARM_SERVICE);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),

                    1000 * 60 * 60 * 24, pendingIntent);


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
                    Intent i = new Intent(this, MyFlights.class);
                    startActivity(i);
                    break;
            }
            switch (item.getItemId()) {
                case R.id.trip:
                    Intent i = new Intent(this, MyTrip.class);
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
    public void onClick(View v) {
        if(v==signIn){
            Intent i = new Intent(this, SignInActivity.class);
            startActivity(i);
        }
        if (v==signUp){
            Intent i = new Intent(this, SignUpActivity.class);
            startActivity(i);
        }

    }
}
