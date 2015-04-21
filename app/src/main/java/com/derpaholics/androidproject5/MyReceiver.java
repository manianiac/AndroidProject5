package com.derpaholics.androidproject5;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    private NotificationManager nm;
    public void doNotification(View v) {

    }

    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "In Broadcast Receiver", Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(context, MyService.class);
        context.startService(myIntent);
    }
}
