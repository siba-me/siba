package com.example.user.siba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.util.Printer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.*;

public class customAdapterPar extends ArrayAdapter<ParkingL> {
    private String imageBitmap;
    private int setImageResource;
    private Context mContext;
    List<ParkingL> parkingLList;


    public customAdapterPar(@NonNull Context mContext, int setImageResource, List<ParkingL> parkingLList) {
        super(mContext,setImageResource,parkingLList);
        this.setImageResource = setImageResource;
        this.mContext = mContext;
        this.parkingLList = parkingLList;
    }



    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(mContext).inflate(Integer.parseInt(String.valueOf(imageBitmap)), parent,false);
        }
        ParkingL p = parkingLList.get(position);
        if (p != null) {
            TextView tvName = (TextView) v.findViewById(R.id.info);
            tvName.setText(p.getInformation());

            ImageView imageView=(ImageView) v.findViewById(R.id.imageView2);
            String image = p.getImage();
            Bitmap imageView1 = StringToBitmap(image);

        }
        return v;
    }

    private Bitmap StringToBitmap(String image) {
        try {
            byte[] encodeByte = Base64.decode(imageBitmap, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0,
                    encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

}


