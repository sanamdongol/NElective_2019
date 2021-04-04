package com.example.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {


    private static final String CHANNEL_ID = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showNotification(View view) {
        switch (view.getId()) {
            case R.id.btn_basic:
                showBasicNotification();
                break;
            case R.id.btn_big_picture:
                showNotificationWithStyle();
                break;
            case R.id.btn_inbox_style:
                showExpandableNotification();
                break;

            case R.id.btn_big_text:
                showBigTextStyleNotification();
                break;

        }
        Toast.makeText(this, "Basic", Toast.LENGTH_SHORT).show();

    }

    private void showBasicNotification() {
        Intent intent = new Intent(this, NotificationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);


        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.honda);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker(getString(R.string.app_name))
                .setContentTitle("title")
                .setContentText("body")
                .setAutoCancel(true)
                .setLargeIcon(bitmap)
                .setContentIntent(pendingIntent)
                .setColor(getResources().getColor(R.color.colorPrimary))
                .setSound(defaultSoundUri);
        //  mBuilder.setContentIntent(pendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence channelName = "Basic Notification";
            String description = getString(R.string.app_name);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channelName, importance);
            channel.setDescription(description);
            mNotificationManager.createNotificationChannel(channel);
        }
        mNotificationManager.notify((int) System.currentTimeMillis(), mBuilder.build());


    }

    private void showNotificationWithStyle() {

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.honda);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Content Title")
                .setContentText("Content Text")
                .setLargeIcon(bitmap)
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(bitmap)
                        .bigLargeIcon(null))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(2, builder.build());


    }

    private void showExpandableNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Event tracker")
                .setTicker("Inbox Style Notification")
                .setContentText("Events received");
        NotificationCompat.InboxStyle inboxStyle =
                new NotificationCompat.InboxStyle();
        String[] events = new String[6];
        events[0] = "Futsal Match";
        events[1] = "Swimming Competition";
        events[2] = "Motorbike Race";
        events[3] = "Boxing Match";
        events[4] = "Chilly Eating Competition";
        events[5] = "Skateboard Stunt";
        // Sets a title for the Inbox in expanded layout
        inboxStyle.setBigContentTitle("Event tracker details:");

        // Moves events into the expanded layout
        for (int i = 0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }

        builder.setStyle(inboxStyle);
        inboxStyle.setBigContentTitle("Events This Week");

        //activity to open when notification is tapped
       /* Intent resultIntent = new Intent(this, NotificationActivity.class);
        //parameters , context, requestCode,intent,flags
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, resultIntent, 0);
        mBuilder.setContentIntent(pendingIntent);
*/

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(2, builder.build());


    }

    private void showBigTextStyleNotification() {

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.honda);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "1")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Content Title")
                .setContentText("Content Text")
                .setLargeIcon(bitmap)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))


                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(2, builder.build());


    }

}
