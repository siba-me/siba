package com.example.user.siba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu,menu);
            return true;
        }

        @Override
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
            return true;

        }
    }
