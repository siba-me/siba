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
            setContentView(R.layout.activity_main2);
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu,menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.item1:
                    Toast.makeText(this, "item menu 1 ", Toast.LENGTH_SHORT).show();
                    break;
            }
            switch (item.getItemId()) {
                case R.id.item2:
                    Toast.makeText(this, "item menu 2 ", Toast.LENGTH_SHORT).show();
                    break;
            }
            switch (item.getItemId()) {
                case R.id.item3:
                    Toast.makeText(this, "item menu 3 ", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;

        }
    }
