package com.example.rishi.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendTextActivity extends AppCompatActivity {

    private Button btnSend;
    private EditText etNumber, etText;

    public void sendMessage(View view){
        Log.i("Send SMS", "");
        String phoneNumber = etNumber.getText().toString();
        String textMessage = etText.getText().toString();
        int num=Integer.parseInt(phoneNumber.toString());
        if(num==10) {
             try {
                 Log.d("test","myTest1");

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber, null, textMessage, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();

                 }

             catch (Exception e) {
                   Toast.makeText(getBaseContext(), "SMS faild, please try again.", Toast.LENGTH_SHORT).show();
             }

       }
        else{
            Toast.makeText(getBaseContext(),"Phone number should be 10 digits",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_text);

        btnSend = (Button)findViewById(R.id.btnSend);

        etNumber = (EditText)findViewById(R.id.etNumber);
        etText = (EditText)findViewById(R.id.etText);


    }
}

