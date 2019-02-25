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
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.user.siba.action.FOO";
    private static final String ACTION_BAZ = "com.example.user.siba.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.example.user.siba.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.user.siba.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
    }


        public class MyNewIntentService extends IntentService {
            private static final int NOTIFICATION_ID = 3;
            public MyNewIntentService() {
                super("MyNewIntentService");
            }
            @Override
            protected void onHandleIntent (Intent intent) {
                Notification.Builder builder = new Notification.Builder(this);
                builder.setContentTitle("My Title");
                builder.setContentText("This is the Body");
                builder.setSmallIcon(R.drawable.whatever);
                Intent notifyIntent = new Intent(this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                //to be able to launch your activity from the notification
                builder.setContentIntent(pendingIntent);
                Notification notificationCompat = builder.build();
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
                managerCompat.notify(NOTIFICATION_ID, notificationCompat);
            }
        }



    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
