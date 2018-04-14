package com.example.loan.calculatorapp;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends ActionBarActivity {

    Button pupsBttn;

    MediaPlayer furz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    pupsBttn = (Button) findViewById(R.id.pupsbttn);
        furz = MediaPlayer.create(this, R.raw.pups1);



        pupsBttn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            furz.start();

            }
        });

    }


}
