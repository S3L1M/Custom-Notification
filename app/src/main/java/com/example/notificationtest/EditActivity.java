package com.example.notificationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;

public class EditActivity extends AppCompatActivity {

    private EditText mTitle;
    private EditText mDetails;
    private SeekBar mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        mTitle = (EditText) findViewById(R.id.et_title);
        mDetails = (EditText) findViewById(R.id.et_details);
        mProgress = (SeekBar) findViewById(R.id.sb_progress);
    }

    public void onClickUpdate(View view) {
        NotificationUtils.updateNotification(mTitle.getText().toString(), mDetails.getText().toString(), mProgress.getProgress());
    }
}