package com.example.rishi.myapp;

        import android.app.Activity;
        import android.media.MediaPlayer;
        import android.media.MediaPlayer.OnBufferingUpdateListener;
        import android.media.MediaPlayer.OnCompletionListener;
        import android.os.Bundle;
        import android.os.Handler;
        import android.view.MotionEvent;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.View.OnTouchListener;
        import android.widget.EditText;
        import android.widget.ImageButton;
        import android.widget.SeekBar;
public class MusicUrlActivity extends Activity implements OnClickListener, OnTouchListener, OnCompletionListener, OnBufferingUpdateListener{

        private ImageButton buttonPlayPause;
        private SeekBar seekBarProgress;
        public EditText editTextSongURL;

        private MediaPlayer mediaPlayer;
        private int mediaFileLengthInMilliseconds; // this value contains the song duration in milliseconds. Look at getDuration() method in MediaPlayer class

        private final Handler handler = new Handler();

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_music_url);
            initView();
        }

        /** This method initialise all the views in project*/
        private void initView() {
            buttonPlayPause = (ImageButton)findViewById(R.id.ButtonTestPlayPause);
            buttonPlayPause.setOnClickListener(this);

            seekBarProgress = (SeekBar)findViewById(R.id.SeekBarTestPlay);
            seekBarProgress.setMax(99); // It means 100% .0-99
            seekBarProgress.setOnTouchListener(this);
            editTextSongURL = (EditText)findViewById(R.id.EditTextSongURL);

            mediaPlayer = new MediaPlayer();
            mediaPlayer.setOnBufferingUpdateListener(this);
            mediaPlayer.setOnCompletionListener(this);
        }

        /** Method which updates the SeekBar primary progress by current song playing position*/
        private void primarySeekBarProgressUpdater() {
            seekBarProgress.setProgress((int)(((float)mediaPlayer.getCurrentPosition()/mediaFileLengthInMilliseconds)*100)); // This math construction give a percentage of "was playing"/"song length"
            if (mediaPlayer.isPlaying()) {
                Runnable notification = new Runnable() {
                    public void run() {
                        primarySeekBarProgressUpdater();
                    }
                };
                handler.postDelayed(notification,1000);
            }
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.ButtonTestPlayPause){
                /** ImageButton onClick event handler. Method which start/pause mediaplayer playing */
                try {
                    mediaPlayer.setDataSource(editTextSongURL.getText().toString()); // setup song from https://www.hrupin.com/wp-content/uploads/mp3/testsong_20_sec.mp3 URL to mediaplayer data source
                    mediaPlayer.prepare(); // you must call this method after setup the datasource in setDataSource method. After calling prepare() the instance of MediaPlayer starts load data from URL to internal buffer.
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mediaFileLengthInMilliseconds = mediaPlayer.getDuration(); // gets the song length in milliseconds from URL

                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    buttonPlayPause.setImageResource(R.drawable.pause);
                }else {
                    mediaPlayer.pause();
                    buttonPlayPause.setImageResource(R.drawable.play);
                }

                primarySeekBarProgressUpdater();
            }
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(v.getId() == R.id.SeekBarTestPlay){
                /** Seekbar onTouch event handler. Method which seeks MediaPlayer to seekBar primary progress position*/
                if(mediaPlayer.isPlaying()){
                    SeekBar sb = (SeekBar)v;
                    int playPositionInMillisecconds = (mediaFileLengthInMilliseconds / 100) * sb.getProgress();
                    mediaPlayer.seekTo(playPositionInMillisecconds);
                }
            }
            return false;
        }

        @Override
        public void onCompletion(MediaPlayer mp) {
            /** MediaPlayer onCompletion event handler. Method which calls then song playing is complete*/
            buttonPlayPause.setImageResource(R.drawable.play);
        }

        @Override
        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            /** Method which updates the SeekBar secondary progress by current song loading from URL position*/
            seekBarProgress.setSecondaryProgress(percent);
        }
    }