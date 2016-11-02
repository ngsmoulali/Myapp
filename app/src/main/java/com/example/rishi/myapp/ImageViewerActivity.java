package com.example.rishi.myapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;

public class ImageViewerActivity extends AppCompatActivity {


    ImageView ivView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        ImageView ivView = (ImageView) findViewById(R.id.ivView);

        Uri receivedUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (receivedUri != null) {
            ivView.setImageURI(receivedUri);

        }


    }
}


