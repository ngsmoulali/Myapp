package com.example.rishi.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GoogleNewsActivity extends AppCompatActivity {
    private TextView tvNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_news);

        Bundle b=getIntent().getExtras();
                tvNews=(TextView)findViewById(R.id.tvNews);
        tvNews.setText(b.getCharSequence("news"));
    }
}
