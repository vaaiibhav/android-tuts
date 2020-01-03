package com.example.notify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String firebasemessage ="New Message";

        showNotify(firebasemessage);

    }

    private void showNotify(String message) {

        NotificationCompat.Builder  notBuilder = new NotificationCompat.Builder(this);
        notBuilder.setContentTitle(message);
        notBuilder.setSmallIcon(R.drawable.ic_launcher_background);
        notBuilder.setContentText("This is some Sampple Text");

        Intent notIntent = new Intent(MainActivity.this, ShowScreenActivity.class);
        notIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pi =  PendingIntent.getActivity(this,0,notIntent,PendingIntent.FLAG_UPDATE_CURRENT );
        notBuilder.setContentIntent(pi);



        NotificationManager mgr= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mgr.notify(0,notBuilder.build());



    }
}
