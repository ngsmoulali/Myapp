package com.example.rishi.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        WebView website=(WebView)findViewById(R.id.wvFelight);
        website.getSettings().setJavaScriptEnabled(true);

        website.loadUrl("file:///android_asset/html.html");

    }
}
