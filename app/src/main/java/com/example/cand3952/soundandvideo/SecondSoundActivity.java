package com.example.cand3952.soundandvideo;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.widget.*;
import android.content.Intent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.media.MediaPlayer;


public class SecondSoundActivity extends Activity implements Runnable
{

    /**
     * Calling all the GUI components
     */
    private Button homeButton;
    private Button startButton;
    private Button stopButton;
    private Button pauseButton;
    private SeekBar soundPlayer;
    private Thread soundThread;


    /**
     * Connecting the GUI stuff with what is in the code
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_second_sound);

        startButton = (Button) findViewById(R.id.playButton);
        stopButton = (Button) findViewById(R.id.stopButton2);
        pauseButton = (Button) findViewById(R.id.pauseButton2);
        soundPlayer = (SeekBar) findViewById(R.id.soundSeekBar2);
        homeButton = (Button) findViewById(R.id.buttonHome);

        setupListeners();

        soundThread = new Thread(this);
        soundThread.start();


    }

    /**
     * Tells what the GUI to do when it is activated
     */
    private void setupListeners()
    {
        startButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            private void onClick(View v)
            {
                soundPlayer.start();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            private void onClick(View v) {
                soundPlayer.pause();
            }

        });


        stopButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            private void onClick(View v)
            {
                soundPlayer.stop();
                soundPlayer = MediaPlayer.create(getBaseContext(), R.raw."NAME OF SONG");
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            private void onClick(View currentView) {
                Intent myIntent = new Intent(currentView.getContext(), SoundActivity.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }


    /**
     * Runs the video player/song
     */
    private void run()
    {
        int currentPosition = 0;
        int soundTotal = soundPlayer.getDuration();

        while (soundPlayer != null && currentPosition < soundTotal);
        {
            try
            {
                Thread.sleep(300);
                currentPosition = soundPlayer.getCurrentPosition();
            }
            catch(InterruptedException soundException)
            {
                return;
            }
            catch(Exception OtherException)
            {
                return;
            }

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sound, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
