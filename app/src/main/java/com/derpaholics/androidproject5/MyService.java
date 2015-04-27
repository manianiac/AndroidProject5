package com.derpaholics.androidproject5;
//Laura Macaluso and William Barron
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    private static final String TAG = "Test";
    private static final int MYNOTIFICATION = 1;
    public static int counts = 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
           NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
           Notification noti = new Notification.Builder(this)
                   .setContentTitle(MainActivity.myPreference.getString("defaultText", "Project 5"))
                   .setContentText("Have recieved " + counts + " notifications")
                   .setSmallIcon(R.drawable.ic_launcher)
                   .setOngoing(false)
                   .build();
           noti.flags |= Notification.FLAG_INSISTENT;
           notificationManager.notify(MYNOTIFICATION, noti);
           stopSelf();

        return 0;
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

}
