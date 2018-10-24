package com.example.user.siba;

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
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            signIn = (Button) findViewById(R.id.MsignIn);
            signUp = (Button) findViewById(R.id.MsignUp);
            signUp.setOnClickListener(this);
            signIn.setOnClickListener(this);


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
                case R.id.airports:
                    Toast.makeText(this, "Airports ", Toast.LENGTH_SHORT).show();
                    break;
            }
            switch (item.getItemId()) {
                case R.id.flight:
                    Intent i = new Intent(this, MyFlights.class);
                    break;
            }
            switch (item.getItemId()) {
                case R.id.trip:
                    Intent i = new Intent(this, MyTrip.class);
                    break;
            }
            switch (item.getItemId()) {
                case R.id.logout:
                    Intent i= new Intent(this,MainActivity.class);
                    break;
            }
            switch (item.getItemId()) {
                case R.id.myParking:
                    Intent i= new Intent(this,MyParking.class);
                    break;
            }
            return true;

        }

    @Override
    public void onClick(View v) {
        if(v==signIn){
            Intent i = new Intent(this, SignInActivity.class);
        }
        if (v==signUp){
            Intent i = new Intent(this, SignUpActivity.class);
        }

    }
}
