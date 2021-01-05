package com.edu.notification_edu;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import static com.edu.notification_edu.MainActivity.NOTIFICATION_CHANNEL_ID;

public class MyReceiver extends BroadcastReceiver {

    static int numMessages;
    static int bigNumber  ;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       // throw new UnsupportedOperationException("Not yet implemented");
        Toast.makeText(context, "Alarm Ringing.....", Toast.LENGTH_SHORT).show();
        // if the time is 12:00 AM is checked by alarm manager
       callMyReminder(context);
        // Call your JobSchedulear :

        //   -> Check if the cell is on charge mode
        //   -> Check id network is good ANY - WIFI - Network
        //   -> check if the cell is idle
        //   ->  It will Install the latest ver of SW on your cell phone

        //    -> What if my Cell BOOTS


        // call notification..
        // intent.getExtras( will have the tim tab name dosage , had it ot not )
        // can create a dropdown list : to sellect an activity based on that notification is displayed...

        // check box if the task is completed.. will be sent to the finished intent...
        // can have reminders too..

    }

    private void callMyReminder(Context context) {


        NotificationCompat.Builder  mBuilder = new NotificationCompat.Builder(context);
        mBuilder.setSmallIcon(R.drawable.ic_launcher);

        mBuilder.setContentTitle("Missed Calls..(Dummy Text)");
        mBuilder.setContentText("Reminder TExt ");
        mBuilder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);

        mBuilder.setNumber(++numMessages); //


        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);  /// Managers.....
        //  mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        // getSystemService is a static method this in turn query to a manager called as service manager for a service called as notification
        //



        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            assert manager != null;
            mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
            manager.createNotificationChannel(notificationChannel);
        }
        assert manager != null;


        manager.notify(1, mBuilder.build());  // he diplays the notification Bar...
    }
}
