package com.example.rishi.myapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
        ImageView ivView = (ImageView) findViewById(R.id.ivView);
        Intent intent = getIntent();
        Uri data = intent.getData();

        if (intent.getType().indexOf("image/") != -1) {
            ivView.setImageURI(data);

        }
        }
}
