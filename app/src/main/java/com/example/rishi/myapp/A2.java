package com.example.rishi.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class A2 extends AppCompatActivity {
    public void submit(View view){

        String name = ((EditText)findViewById(R.id.etA2)).getText().toString();
        Intent intent = new Intent();
        intent.putExtra("username", name);
        //setIntent(intent);
        setResult(RESULT_OK, intent);

        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);
    }
}
