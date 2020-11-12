package com.example.notificationtest;

import android.app.IntentService;
import android.content.Intent;
import androidx.annotation.Nullable;

public class backgoundService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public backgoundService() {
        super("backgroundService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        // First-time run
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NotificationUtils.buildNotification(this);
        NotificationUtils.updateNotification(getString(R.string.notification_title), getString(R.string.notification_body), 33);
    }
}
