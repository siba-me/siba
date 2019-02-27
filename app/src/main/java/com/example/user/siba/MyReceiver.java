package com.example.user.siba;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //this is the broadcast receiver class.
                Intent intent1 = new Intent(context, MyIntentService2.class);
                context.startService(intent1);
            }
        }




