package com.example.user.siba;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which==dialog.BUTTON_POSITIVE){
            Toast.makeText(this, "yohooo ", Toast.LENGTH_SHORT).show();
        }
        if(which==dialog.BUTTON_NEGATIVE){
            Toast.makeText(this, "Nooooo :(!! ", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setMessage("Are you sure");
        builder.setCancelable(false);
        builder.setPositiveButton("yes",this);
        builder.setNegativeButton("No",this);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
