package com.example.pcoscar.firebasepush.Service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.pcoscar.firebasepush.MainActivity;
import com.example.pcoscar.firebasepush.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessaging extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        super.onMessageReceived(remoteMessage);
        showNotification(remoteMessage.getNotification());


      //  Log.d("FIREBASE", remoteMessage.getNotification().getBody());
    }

    private void showNotification(RemoteMessage.Notification notification) {
        Intent intent =new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(notification.getTitle())
                .setContentText(notification.getBody())
                .setSound(alarmSound)
                .setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 })
                .setLights(Color.RED, 3000, 3000)
                .setTicker("Nuevo Mensaje")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, builder.build());


   }

}
