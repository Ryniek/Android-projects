package com.example.lab8_android_part1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, MessageService.class);
        intent.putExtra(MessageService.EXTRA_MESSAGE, getResources().getString(R.string.button_response));
        startService(intent);
    }

    public void onClickNotfication(View view) {
        Intent intent = new Intent(this, NotificationService.class);
        intent.putExtra(MessageService.EXTRA_MESSAGE, getResources().getString(R.string.button_text_notification));
        startService(intent);
    }

}
