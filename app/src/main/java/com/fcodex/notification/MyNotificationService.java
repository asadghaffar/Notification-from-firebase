package com.fcodex.notification;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyNotificationService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        show(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());

    }

    public void show (String title, String message){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "Mynotification")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.bet)
                .setAutoCancel(true)
                .setContentText(message);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(999, builder.build());


    }

}