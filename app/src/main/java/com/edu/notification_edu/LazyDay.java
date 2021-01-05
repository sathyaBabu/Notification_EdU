package com.edu.notification_edu;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.edu.notification_edu.R;

public class LazyDay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazy_day);

        NotificationManager notificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);

        // TODO : Pass Notification ID via putIntent.. That can be received here..

        notificationManager.cancel( 1 );  // Not Right....
    }
}
