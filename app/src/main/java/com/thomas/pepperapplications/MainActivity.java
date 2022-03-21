package com.thomas.pepperapplications;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private VideoView bgVideo;
    private Button englishButton;
    private Button italianButton;

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

        englishButton = findViewById(R.id.englishButton);
        italianButton = findViewById(R.id.italianButton);

        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEnglishDialog();
            }
        });

        italianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openItalianDialog();
            }
        });
    }

    private void openEnglishDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Turn the hand on your left")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void openItalianDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Gira la mano alla tua desta")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //do things
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}