package com.edu.notification_edu;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

//

// candy crush package name
// com.king.candycrushsaga

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
// https://developer.android.com/training/notify-user/channels
    private Button simpleNotificationButton, bigStyleNotificationButton;
    public static final String NOTIFICATION_CHANNEL_ID = "201";


    private  static  final int Uni_Number = 1 ;

    static int numMessages;
    static int bigNumber  ;

    private PendingIntent pendingIntent;

    private  PowerManager.WakeLock wakeLock;


    @SuppressLint("InvalidWakeLockTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleNotificationButton   =   (Button) findViewById(R.id.simpleNotificationButton);
        bigStyleNotificationButton =   (Button) findViewById(R.id.bigStyleNotificationButton);

        simpleNotificationButton.setOnClickListener(this);
        bigStyleNotificationButton.setOnClickListener(this);



        // Job schedulears....



        Calendar calendar = Calendar.getInstance(); // static function

        // Get your date and time picker widget..
        // spool the date and time clicked by the user to the following lines..

        // tablet 3 times.. Call Notifications

        // NOTE DATE & TIME is relevent to the emulator..



// Your time can be stored and retr.. from shared pref...



        calendar.set(Calendar.MONTH,calendar.JANUARY);
        calendar.set(Calendar.YEAR,2021);
        calendar.set(Calendar.DAY_OF_MONTH,1);

        calendar.set(Calendar.HOUR_OF_DAY,11);
        calendar.set(Calendar.MILLISECOND,00);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MINUTE,53);
        calendar.set(Calendar.AM_PM,calendar.PM);


        Intent myIntent = new Intent(MainActivity.this,MyReceiver.class);// Broad cast receiver
        pendingIntent  = PendingIntent.getBroadcast(MainActivity.this,0,myIntent,0);

         // SendBroadcast();  ??????

        // Job schedulear/WorkManager ... will not use the timer interrupt or RTC...

        // To upload the data Cr : time - wify On - phone should be in USB Power mode, IDLE   12.

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.set(AlarmManager.RTC,calendar.getTimeInMillis(),pendingIntent);
        //                                    45986786866

        // sleep...  CPU sleeps...

        PowerManager powerManager = (PowerManager) this.getSystemService(POWER_SERVICE);

        wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "My Tag");



        wakeLock.acquire();  // Battery drains...

        // wakeLock.release();  // release the power manager...  battery consumption is stopped...






    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.simpleNotificationButton:
                displaySimpleNotification("My text Goes here.... .");
                break;
            case R.id.bigStyleNotificationButton:

                scheduleNotificationWithButton("Whats your INTENT today? Work or Chill...");
                break;
        }
    }


    // NOTE : we dont have pending intents here....


    private void displaySimpleNotification(String text) {



// 1.
        NotificationCompat.Builder  mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(R.drawable.ic_launcher);

        mBuilder.setContentTitle("Missed Calls..(Dummy Text)");
        mBuilder.setContentText(text);
        mBuilder.setSound(Settings.System.DEFAULT_NOTIFICATION_URI);

        mBuilder.setNumber(++numMessages); //

// 2.   we have 130 managers PowerManager AlarmManager PackageManager TelePhonymanager
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  /// Managers.....

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





    //  Big notification with Button
    private void scheduleNotificationWithButton(String message) {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.kidsface);
        //What happen when you will click on button
        // Assume its a camera activity..
        // we have to use camera permissions...
        // we can declare all use permissions related to WorkActivity( Camera ) in our app manifest.. Advantage we have in pending intent..
        Intent intent  = new Intent(this, workActivity.class);
        Intent intent2 = new Intent(this, LazyDay.class);




        ///////// startActivity(intent);  // call me right now......


        // I want to call a voice recorder being in telephony object...


        // register workActivity Intent in pending intent..
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_ONE_SHOT);



        // PendingIntent.getBroadcast()
        //pendingIntent.getIntentSender()

//        PendingIntent.getBroadcast()
//        PendingIntent.getService()





        PendingIntent pendingIntent2 = PendingIntent.getActivity(this, 1, intent2, PendingIntent.FLAG_ONE_SHOT);

        //Button
        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.mipmap.car, "Work..", pendingIntent).build();
        NotificationCompat.Action action2 = new NotificationCompat.Action.Builder(R.mipmap.butterfly, "LAZY Day..", pendingIntent2).build();

        //Notification

        NotificationCompat.Builder notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("Get to Work Activity")
                //.setStyle(new NotificationCompat.BigTextStyle()
                //      .bigText(message))
                .setNumber(++bigNumber)
                .setContentTitle("Lets rule the World...")
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(bitmap).setSummaryText(message))


                .addAction(action) //add buton  work
                .addAction(action2) //add buton  butter fly lazy day

                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)

                .setDefaults(Notification.DEFAULT_ALL); // requires VIBRATE permission
               // .build();

        //Send notification
        NotificationManager manager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);


        // Please use Bundle to pass this 2 to other activity..

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "NOTIFICATION_CHANNEL_NAME", importance);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.GREEN);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            assert manager != null;
           notification.setChannelId(NOTIFICATION_CHANNEL_ID);

            manager.createNotificationChannel(notificationChannel);
        }
        assert manager != null;


       manager.notify(1, notification.build());
        // Please port this value using Bundle to Work r lazy activity
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();

        wakeLock.release();
    }
}

/*

Notification channels: Android 8.0 introduces notification channels that allow you to create a user-customizable channel
for each type of notification you want to display.

Notification dots: Android 8.0 introduces support for displaying dots, or badges, on app launcher icons.
 Notification dots reflect the presence of notifications that the user has not yet dismissed or acted on.

Snoozing: Users can snooze notifications, which causes them to disappear for a period of time before reappearing. Notifications reappear
 with the same level of importance they first appeared with.

Messaging style: In Android 8.0, notifications that use the MessagingStyle class display more content in their collapsed form.
You should use theMessagingStyle class for notifications that are messaging-related.

// https://developer.android.com/reference/android/app/Notification.MessagingStyle.html


 */