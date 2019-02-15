package com.example.user.siba;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyParking extends AppCompatActivity implements View.OnClickListener{
    private static final int CAMERA_REQUEST = 0;
    Button btTakePhoto, btGallery;
    ImageView imageView2;
    //A bitmap is a type of memory organization or image file format used to store digital images.
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_parking);
        btTakePhoto = (Button) findViewById(R.id.btTakePhoto);
        btTakePhoto.setOnClickListener(this);
        btGallery = (Button) findViewById(R.id.btGallery);
        btGallery.setOnClickListener(this);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == CAMERA_REQUEST && resultCode== Activity.RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            saveImage(bitmap);
            String imagePath= saveImage(bitmap);
            SharedPreferences pref = getSharedPreferences("mypref",MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("image",imagePath);
            editor.commit();
            imageView2.setImageBitmap(photo);

        }
    }
    public String saveImage(Bitmap bitmap){
        File root = Environment.getExternalStorageDirectory();
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = root.getAbsolutePath()+"/DCIM/Camera/IMG_"+timeStamp+".jpg";
        File file = new File(filePath);//creating an object from type File
        try
        {
            file.createNewFile();
            FileOutputStream ostream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,ostream);
            ostream.close();
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this,"Failed to save image",Toast.LENGTH_SHORT).show();
        }
        return filePath;

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
            case R.id.trip:
                Intent i = new Intent(this,MyTrip.class);
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
            case R.id.logout:
                Intent i= new Intent(this,MainActivity.class);
                startActivity(i);
                break;
        }
        return true;

    }

}
