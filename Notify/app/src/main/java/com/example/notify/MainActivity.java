package com.example.notify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String firebasemessage ="";

       showNotify(firebasemessage);

    }

    private void showNotify(String message) {

        NotificationCompat.Builder  notBuilder = new NotificationCompat.Builder(this);
        notBuilder.setContentTitle(message);
        notBuilder.setSmallIcon(R.drawable.ic_launcher_background);
        notBuilder.setContentText("This is some Sampple Text");


        NotificationManager mgr= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mgr.notify(0,notBuilder.build());}
}
