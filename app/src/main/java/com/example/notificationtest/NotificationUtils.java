package com.example.notificationtest;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

public class NotificationUtils {

    private static final int PENDING_INTENT_ID = 0x468E68;
    private static final int NOTIFICATION_ID = 0xA1138;
    private static final String NOTIFICATION_CHANNEL_ID = "progress_notification_channel";
    private static NotificationManager notificationManager;
    private static NotificationCompat.Builder notificationBuilder;
    private static RemoteViews notificationLayout = new RemoteViews("com.example.notificationtest", R.layout.notification);
    private static PendingIntent contentIntent(Context context) {
        Intent startActivityIntent = new Intent(context, EditActivity.class);
        return PendingIntent.getActivity(context, PENDING_INTENT_ID, startActivityIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public static void buildNotification(Context context) {
        notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    NOTIFICATION_CHANNEL_ID,
                    context.getString(R.string.main_notification_channel_name),
                    NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(mChannel);
        }
        notificationBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
                .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(notificationLayout)
                .setContentIntent(contentIntent(context));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            notificationBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
        }
    }

    public static void updateNotification(String title, String details, int progress) {
        notificationLayout.setTextViewText(R.id.tv_title, title);
        notificationLayout.setTextViewText(R.id.tv_details, details);
        notificationLayout.setProgressBar(R.id.pb_progress, 100, progress, false);
        notificationBuilder.setCustomContentView(notificationLayout);
        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
    }

}
