package com.example.rishi.myapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MusicRawActivity extends AppCompatActivity {
    private ImageButton play;
    private ImageButton stop;
    private MediaPlayer mPlayer;
    public void click(View v){
        switch (v.getId()){
            case R.id.ibPlay:
                mPlayer.start();
                break;
            case R.id.ibPause:
                mPlayer.pause();
                break;
            case R.id.btnStop:
                mPlayer.stop();
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_raw);
        play=(ImageButton)findViewById(R.id.ibPlay);
        stop=(ImageButton)findViewById(R.id.ibPause);
        mPlayer=MediaPlayer.create(getApplicationContext(),R.raw.jhonny);
    }
}
