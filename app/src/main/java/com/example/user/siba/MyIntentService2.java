package com.example.user.siba;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.support.v4.app.NotificationManagerCompat;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService2 extends IntentService {

        private static final int NOTIFICATION_ID = 3;

        public MyIntentService2() {

            super("MyNewIntentService");

        }

        @Override

        protected void onHandleIntent (Intent intent) {

            Notification.Builder builder = new Notification.Builder(this);

            builder.setContentTitle("Time left");

            builder.setContentText("Time left:");

            builder.setSmallIcon(R.drawable.dog);

            Intent notifyIntent = new Intent(this, MainActivity.class);

            PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

//to be able to launch your activity from the notification

            builder.setContentIntent(pendingIntent);

            Notification notificationCompat = builder.build();

            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);

            managerCompat.notify(NOTIFICATION_ID, notificationCompat);

        }


    }
