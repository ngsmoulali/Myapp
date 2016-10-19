package com.example.rishi.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.rishi.myapp.Utils.Utils;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("Help");
        menu.add("Settings");
        menu.add("About");


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Utils.toast(getBaseContext(), item.getTitle().toString());
        // Toast.makeText(getBaseContext(),item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
