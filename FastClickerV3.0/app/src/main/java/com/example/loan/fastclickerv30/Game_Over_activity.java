package com.example.loan.fastclickerv30;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ListIterator;

public class Game_Over_activity extends ActionBarActivity {

    ListView scoreLV;
    Button playAgain;
    Intent playAgainInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__over_activity);
        String[] Score_Array = new String[] { "DDizzle:912312312ERROR001","Kzizzle:9001", "Player 4: Unset", "Player 5: Unset"};//an diesen array wird später einfach immer etwas hinzugefügt , evtenntuell  nenn array arraay [5][] machen für max 5 top playerss

        View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        playAgainInt= new Intent(this, Start_menue.class);
        playAgain = (Button) findViewById(R.id.playAgainBttn);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(playAgainInt);
            }
        });

        //Score LV setup
        //Todo, am 2. Paraeter arbeiten und am Layout sodass der Score ssichtbar ist auf dem Screen!
       // scoreLV=(ListView)findViewById(R.id.scoreLVID);
//        ArrayAdapter<String> codeLearnArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, Score_Array);
  //      scoreLV.setAdapter(codeLearnArrayAdapter);


    }


}
