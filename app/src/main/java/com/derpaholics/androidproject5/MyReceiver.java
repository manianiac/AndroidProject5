package com.derpaholics.androidproject5;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.view.View;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    SettingsActivity s = new SettingsActivity();

    private NotificationManager nm;
    public void doNotification(View v) {

    }

    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "In Broadcast Receiver", Toast.LENGTH_SHORT).show();
        MyService.counts++;
        //SharedPreferences.Editor e = MainActivity.myPreference.edit();

        //This is deprecated
//        Preference pref = s.findPreference("broadcastCounter");
//        pref.setSummary(Integer.toString(MyService.counts));

        if(MainActivity.myPreference.getBoolean("EnableNotifications", true)) {
            Intent myIntent = new Intent(context, MyService.class);
            context.startService(myIntent);
        }
    }
}
