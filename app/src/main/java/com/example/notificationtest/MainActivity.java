package com.example.notificationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(this, "Notification will be shown in 5 sec", Toast.LENGTH_LONG).show();

        // End activity
        finish();
    }
}