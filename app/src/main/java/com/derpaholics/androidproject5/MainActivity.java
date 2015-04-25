package com.derpaholics.androidproject5;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    private static final int MYNOTIFICATION = 1;
    private int currentNotification = MYNOTIFICATION;
    public static SharedPreferences myPreference;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPreference = PreferenceManager.getDefaultSharedPreferences(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent myIntent = new Intent(this, SettingsActivity.class);
            startActivity(myIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


//    public void doNotification(View v) {
//        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//
//        Notification noti = new Notification.Builder(this)
//                .setContentTitle(getString(R.string.app_name))
//                .setContentText("Just a Notice")
//                .setSmallIcon(R.drawable.ic_launcher)
//                .setOngoing(false)
//                .build();
//
//        noti.flags |= Notification.FLAG_INSISTENT;
//
//        notificationManager.notify(MYNOTIFICATION, noti);
//    }

    //will i changed this because I think this is not supposed to be recursive... was sendBroadcast(...)
    public void doBroadcast(View v) {
        if (myPreference.getBoolean("EnableBroadcast", true)) {

            Intent myIntent = new Intent("com.derpaholics.androidproject5.NOTIFICATION");
            sendBroadcast(myIntent);

        }
        else {
            Toast.makeText(this, "Broadcast are not enabled, see settings", Toast.LENGTH_SHORT).show();
        }
    }

    public void resetCount(View v) {
        MyService.counts = 0;
        //this needs work
        myPreference.edit().putString("broadcastCounter", Integer.toString(MyService.counts));
    }
}
