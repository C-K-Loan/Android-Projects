package com.example.loan.kittyworlddominationsimulator2015;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class opening_Screen extends ActionBarActivity {

    public Button continue_Button, newGame_Button, options_Button, credits_Button;
    public MediaPlayer button_Press_Sound;
    public Intent goto_Continue, goto_NewGame, goto_Options, goto_Credits;

    /**
     *TODO
     * continue.java, newGame.JAva, options.java, creidts.java
     *
     * Setup Meow Media Player Button Press sound
     *
     */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening__screen);

        //setting up Buttons
        continue_Button=(Button)findViewById(R.id.continue_Bttn);
        newGame_Button=(Button)findViewById(R.id.newGame_Bttn);
        options_Button=(Button)findViewById(R.id.options_Bttn);
        credits_Button=(Button)findViewById(R.id.credits_Bttn);

        //Setting Up Intents
        goto_Continue=new Intent(getApplicationContext(), Continue.class);
        goto_NewGame= new Intent(getApplicationContext(), newGame.class);
        goto_Credits= new Intent(getApplicationContext(), credits.class);
        goto_Options= new Intent(getApplicationContext(), options.class);


        continue_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(goto_Continue);
            }
        });

        newGame_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(goto_NewGame);

            }
        });

        options_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(goto_Options);

            }
        });


        credits_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(goto_Credits);

            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_opening__screen, menu);
        return true;
    }


}
