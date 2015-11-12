package com.example.cand3952.soundandvideo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import android.widget.*;
import android.net.Uri;
import android.content.Intent;





public class VideoActivity extends Activity
{

    private VideoView myPlayer;
    private Button returnButton;
    private MediaController myVideoController;
    private Uri videoLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_video);

        myPlayer = (VideoView) findViewById(R.id.videoView);
        returnButton = (Button) findViewById(R.id.homeButton);

        videoLocation = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.shia);
        myVideoController = new MediaController(this);
        //Prepare the video
        setupMedia();
        setupListeners();
    }

    private void setupMedia()
    {
        myPlayer.setMediaController(myVideoController);
        myPlayer.setVideoURI(videoLocation);
    }

    private void setupListeners()
    {
        returnButton.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View currentView)
            {
                Intent returnIntent = new Intent();
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }

}
