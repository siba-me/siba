package com.example.user.siba;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customAdapterPar extends ArrayAdapter<ParkingL> {
    private String imageBitmap;
    private Context mContext;


    public customAdapterPar(@NonNull Context context, String imageBitmap) {
        super(context, Integer.parseInt(imageBitmap));
        this.imageBitmap = imageBitmap;
        this.mContext = context;
    }

}
