package com.example.rishi.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ImageAnimationsActivity extends AppCompatActivity {
    private ImageView ivPic;
    private Animation animAlpha;
    private Animation animTranslate;
    private Animation animScale;
    private Animation animRotate;

    public void animation(View v){
        switch (v.getId()){
            case R.id.btnAlpha:
                final Animation animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
                ivPic.startAnimation(animAlpha);
                break;
            case R.id.btnRoatate:
                final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
                ivPic.startAnimation(animRotate);


                break;
            case R.id.btnScale:
                final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
                ivPic.startAnimation(animScale);
                break;
            case R.id.btnTranslate:
                final Animation animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
                ivPic.startAnimation(animTranslate);
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_animations_activity);
        ivPic=(ImageView)findViewById(R.id.ivPic);



    }
}
