package com.example.rishi.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GreetUserActivity extends AppCompatActivity {
    private EditText etFname,etLname;
    private Button btnGreet;
    private TextView tvGreet;


   public void greetingMessage(View v) {
       String fName=etFname.getText().toString();
       String lName=etLname.getText().toString();

           if(TextUtils.isEmpty(fName)||TextUtils.isEmpty(lName)) {
               tvGreet.setText("Please enter details");
           }
           else {
               tvGreet.setText("Namasthe" + fName + "   " + lName );
           }

   }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greet_user);
        etFname=(EditText)findViewById(R.id.etFname);
        etLname=(EditText)findViewById(R.id.etLname);
        btnGreet=(Button)findViewById(R.id.btnGreet);
        tvGreet=(TextView)findViewById(R.id.tvGreet);

    }
}
