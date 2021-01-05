package com.edu.notification_edu;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class workActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);
        Toast.makeText(this, "In work activity...", Toast.LENGTH_SHORT).show();

        // display all work related text / sms etc....
        // How to kill  the notification bar when user has choosen work activity..

        NotificationManager notificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);

        // TODO : Pass Notification ID via putIntent.. That can be received here..

        notificationManager.cancel( 1 );  // Notification Id is IMP.. and cancel i sdeleting the notification at the notification BAR
}
}
