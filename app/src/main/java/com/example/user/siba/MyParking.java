package com.example.user.siba;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyParking extends AppCompatActivity implements View.OnClickListener{
    private static final int CAMERA_REQUEST = 0;
    private static final int SELECT_IMAGE = 1;
    Button btTakePhoto, btGallery;
    ImageView imageView2;

    private FirebaseAuth mAuth=FirebaseAuth.getInstance();
    FirebaseUser currentUser = mAuth.getCurrentUser();
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference myRef = database.getReference("Users");

    //A bitmap is a type of memory organization or image file format used to store digital images.
    Bitmap bitmap;
    Bitmap photo;
    EditText info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_parking);
        btTakePhoto = (Button) findViewById(R.id.btTakePhoto);
        btTakePhoto.setOnClickListener(this);
        btGallery = (Button) findViewById(R.id.btGallery);
        btGallery.setOnClickListener(this);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        info = findViewById(R.id.info);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == CAMERA_REQUEST && resultCode== Activity.RESULT_OK){
           photo = (Bitmap) data.getExtras().get("data");
            imageView2.setImageBitmap(photo);
            String image = BitMapToString(photo);
            ParkingL parkingL = new ParkingL(image, info.getText().toString());
            myRef.child(currentUser.getUid()).child("Parking").push().setValue(parkingL);
            Intent i = new Intent(this,parkingList.class);
            startActivity(i);

        }else if(requestCode == SELECT_IMAGE && resultCode == Activity.RESULT_OK){
            Uri targetUri = data.getData();
            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                String image = BitMapToString(photo);
                imageView2.setImageBitmap(bitmap);
            } catch (FileNotFoundException e){
                e.printStackTrace();

            }
            Intent i = new Intent(this,parkingList.class);
            startActivity(i);
        }


    }

    // from bitmap to string
    public String BitMapToString ( Bitmap bitmap){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,baos);
        byte [] b= baos.toByteArray();
        String temp = Base64.encodeToString(b,Base64.DEFAULT);
        return temp;

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v==btTakePhoto){
            Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(i,CAMERA_REQUEST);

        }
        if(v ==btGallery){
            Intent i = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(i,SELECT_IMAGE);
        }
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
        switch (item.getItemId()) {
            case R.id.parkingList:
                Intent i= new Intent(this,parkingList.class);
                startActivity(i);
                break;
        }

        return true;

    }
    // from string to bitmap
    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0,
                    encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
