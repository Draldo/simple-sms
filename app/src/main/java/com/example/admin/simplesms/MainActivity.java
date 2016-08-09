package com.example.admin.simplesms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mPhone;
    private EditText mSmsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPhone = (EditText) findViewById(R.id.phone_number);
        mSmsText = (EditText) findViewById(R.id.main_text);
    }

    public void doMagic(View view) {

        String phone = mPhone.getText().toString();
        String text = mSmsText.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phone, null, text, null, null);
            Toast.makeText(getApplicationContext(), "SMS send successful", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"SMS failed", Toast.LENGTH_SHORT).show();
        }
    }
}
