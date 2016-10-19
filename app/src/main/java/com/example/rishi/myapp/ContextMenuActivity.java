package com.example.rishi.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.rishi.myapp.Utils.Utils;

public class ContextMenuActivity extends AppCompatActivity {

    private TextView tvText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        tvText=(TextView)findViewById(R.id.tvText);
        registerForContextMenu(tvText);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("This is context Menu");
        menu.add("Copy");
        menu.add("Delete");
        menu.add("Edit");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if((item.getTitle())=="Copy"){
            Utils.toast(getBaseContext(),item.getTitle().toString());
        }
        else if((item.getTitle())=="Delete"){
            Utils.toast(getBaseContext(),item.getTitle().toString());
        }
        else if((item.getTitle())=="Edit"){
            Utils.toast(getBaseContext(),item.getTitle().toString());
        }

        return super.onContextItemSelected(item);
    }
}
