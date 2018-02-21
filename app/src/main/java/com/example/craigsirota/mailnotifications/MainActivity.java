package com.example.craigsirota.mailnotifications;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button contacts;
    private Button letter;
    private Button pack;

    private EditText num;

    private int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;

    private String letterMessage;
    private String packMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts = (Button) findViewById(R.id.contactSelect);
        letter = (Button) findViewById(R.id.letter);
        pack = (Button) findViewById(R.id.Package);
        num = (EditText) findViewById(R.id.num);

        letterMessage = "Hey man, just wanted to let you know that you got mail today.";
        packMessage = "Hey man, just wanted to let you know that you got a package today.";
    }

    public void contactsSelect(View v) {
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
    }

    public void letterSend(View v) {
        String phone = num.getText().toString();

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                !=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
        }
        else
        {
            SmsManager sms = SmsManager.getDefault();
            
            sms.sendTextMessage(phone, null, letterMessage,
                    null, null);
        }
    }
    public void packageSend(View v) {
        String phone = num.getText().toString();

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                !=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
        }
        else
        {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phone, null, packMessage,
                    null, null);
        }
    }


}
