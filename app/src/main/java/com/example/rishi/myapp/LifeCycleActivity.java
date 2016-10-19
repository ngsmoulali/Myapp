package com.example.rishi.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LifeCycleActivity extends AppCompatActivity {
    String msg = "Android : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);
        Log.d(msg, "The onCreate() event");


    }


    @Override
    protected void onStart() {
                super.onStart();
                Log.d(msg, "The onStart() event");
    }


            @Override
            protected void onResume() {
                super.onResume();
                Log.d(msg, "The onResume() event");
            }

            /** Called when another activity is taking focus. */
            @Override
            protected void onPause() {
                super.onPause();
                Log.d(msg, "The onPause() event");
            }

            /** Called when the activity is no longer visible. */
            @Override
            protected void onStop() {
                super.onStop();
                Log.d(msg, "The onStop() event");
            }

            /** Called just before the activity is destroyed. */
            @Override
            public void onDestroy() {
                super.onDestroy();
                Log.d(msg, "The onDestroy() event");
            }
        }

