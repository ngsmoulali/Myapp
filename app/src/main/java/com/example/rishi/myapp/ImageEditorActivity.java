package com.example.rishi.myapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.os.Bundle;

public class ImageEditorActivity extends AppCompatActivity {
    ImageView ivEdit;
    private static final int CAMERA_REQUEST = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_editor);
        ivEdit=(ImageView)findViewById(R.id.ivEdit);
    }
    public void handleImage(){
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        Uri receivedUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (receivedUri != null) {
            ivEdit.setImageURI(receivedUri);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Camera");
        menu.add("Gallery");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle().toString()=="camera") {

        }
        else if(item.getTitle().toString()=="Gallery"){

        }
        return super.onOptionsItemSelected(item);
    }
}
