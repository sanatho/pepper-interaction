package com.thomas.pepperapplications;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView bgVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        bgVideo = (VideoView) findViewById(R.id.bgVideo);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bgvideo);
        bgVideo.setVideoURI(uri);
        bgVideo.start();

        bgVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
    }
}