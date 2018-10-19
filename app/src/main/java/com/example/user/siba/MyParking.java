package com.example.user.siba;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MyParking extends AppCompatActivity implements View.OnClickListener{
    Button button_image;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_parking);
        button_image = (Button)findViewById(R.id.button_image);
        imageView = (ImageView)findViewById(R.id.imageview);
        }


    @Override
    public void onClick(View v) {


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

        switch (item.getItemId()) {
            case R.id.logout:
                Intent i= new Intent(this,MainActivity.class);
                break;
        }
        return true;

    }

}
