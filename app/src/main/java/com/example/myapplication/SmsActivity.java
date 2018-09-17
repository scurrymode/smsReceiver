package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SmsActivity extends AppCompatActivity {
    TextView sender;
    TextView contents;
    TextView receivedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        sender = (TextView) findViewById(R.id.sender);
        contents = (TextView) findViewById(R.id.contents);
        receivedDate = (TextView) findViewById(R.id.receivedDate);

        Intent passedIntent = getIntent();
        processIntent(passedIntent);
    }

    private void processIntent(Intent intent){
        if(intent != null){
            String sd = intent.getStringExtra("sender");
            String ct = intent.getStringExtra("contents");
            String rd = intent.getStringExtra("receivedDate");

            sender.setText(sd);
            contents.setText(ct);
            receivedDate.setText(rd);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processIntent(intent);
        super.onNewIntent(intent);
    }
}
