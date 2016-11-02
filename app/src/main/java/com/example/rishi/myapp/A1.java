package com.example.rishi.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class A1 extends AppCompatActivity {
    Button btnA1;
    TextView tvName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);
        btnA1=(Button)findViewById(R.id.btnA1);
        tvName=(TextView)findViewById(R.id.tvName);
    }
    public void gotoA2(View view){
        Intent intent=new Intent(getBaseContext(),A2.class);
        startActivityForResult(intent,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1000 && resultCode == RESULT_OK) {
            tvName.setText(data.getStringExtra("username"));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
