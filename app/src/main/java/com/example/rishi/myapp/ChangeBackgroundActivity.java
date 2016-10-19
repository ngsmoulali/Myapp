package com.example.rishi.myapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ChangeBackgroundActivity extends AppCompatActivity {
    private Button btnChange;
    private PopupMenu popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_background);
        btnChange = (Button) findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu popup = new PopupMenu(ChangeBackgroundActivity.this, btnChange);
                popup.getMenuInflater().inflate(R.menu.popupmenu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getTitle()=="Red"){
                            btnChange.setBackgroundColor(Color.RED);
                        }
                        else if(item.getTitle()=="Blue") {
                            btnChange.setBackgroundColor(Color.BLUE);
                        }
                        else if(item.getTitle()=="Green") {
                            btnChange.setBackgroundColor(Color.GREEN);
                        }


                        return true;
                    }
                });
                popup.show();

            }
        });


    }
}
