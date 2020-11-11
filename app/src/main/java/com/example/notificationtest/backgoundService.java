package com.example.notificationtest;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;

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
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // First-time run
            }
        }, 5000);
    }
}
