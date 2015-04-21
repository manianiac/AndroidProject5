package com.derpaholics.androidproject5;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {


    private static final int MYNOTIFICATION = 1;
    private int currentNotification = MYNOTIFICATION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


    public void doNotification(View v) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification noti = new Notification.Builder(this)
                .setContentTitle(getString(R.string.app_name))
                .setContentText("Just a Notice")
                .setSmallIcon(R.drawable.ic_launcher)
                .setOngoing(false)
                .build();

        noti.flags |= Notification.FLAG_INSISTENT;

        notificationManager.notify(MYNOTIFICATION, noti);
    }

    public void sendBroadcast(View v)
    {
        Intent myIntent = new Intent("com.derpaholics.androidproject5.NOTIFICATION");
        sendBroadcast(myIntent);
    }
}
