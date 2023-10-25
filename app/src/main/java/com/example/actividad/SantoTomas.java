package com.example.actividad;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class SantoTomas extends AppCompatActivity {
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_santo_tomas);
        video = findViewById(R.id.videoView);
        video.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videost));
        MediaController media = new MediaController(this);
        video.setMediaController(media);
        media.setAnchorView(video);
        video.start();
    }
}
