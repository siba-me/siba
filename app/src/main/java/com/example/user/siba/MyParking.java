package com.example.user.siba;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
}