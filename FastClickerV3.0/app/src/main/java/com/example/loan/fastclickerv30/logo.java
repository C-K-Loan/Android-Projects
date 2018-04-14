package com.example.loan.fastclickerv30;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class logo extends ActionBarActivity {
    Intent change_screen;
    MediaPlayer startsound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Thread thread = new Thread();

        startsound= new MediaPlayer().create(this, R.raw.launch_sound);
        thread=  new Thread(){
            @Override
            public void run(){
                try {
                    synchronized(this){
                        wait(10);
                    }
                }
                catch(InterruptedException ex){
                }

                // TODO
            }
        };

        thread.start();
        startsound.start();
        change_screen = new Intent(getApplicationContext(),Start_menue.class);
    }


}
