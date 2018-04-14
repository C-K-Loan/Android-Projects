package com.example.loan.fastclickerv30;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

import java.util.Random;


//    ListView lvItems;         lvItems =(ListView) findViewById(R.id.lvlitems);//hiermit hole ich mir mein listview in meinen JAva code

public class Start_menue extends ActionBarActivity  {




    Random psuedoRandom = new Random();
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__screen);
        //b1.setBackgroundColor(Color.CYAN);
        //b1.setBackground(getDrawable());

        //ka iwie nutzlos
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);

        Button bstart = (Button) findViewById(R.id.bttnStart);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

    }
        // TODO
         //android:background="@drawable/start_screen_background"
        // adde das in XML file mit passendes Background!


    //bringt die Game activity hervor
   //inizialisiert buttons
    public void startGame(View v ){

        // ok was ist ein view?
        // ein view ist soein teil das man braucht wenn man android sagen will das es wasm achen soll
        // wenn ich z.b. will das meine activity gecahnged wird, brauche ich dafür erstmal ein intent
        // der erste parameter ka , einfach "this machen"
        // der zweite parameter gibt an zu welcher activity wir switchen wollen ( wobei man den namen dieser klaasse angibt)
        Intent intent = new Intent(this, Game_Screen.class);
        startActivity(intent);//launceh die activity, on start on resume etc wird geladen

;

    }

    //inizialisiert  level
    //todo
    //aus settext set background machen und true false grafiken einrichten
  /*  public void makeLevel(){

    int level= psuedoRandom.nextInt(3);

        switch (level) {
            // alle möglichen layouts, eins wird zufällig gewählt
            case 0:
              //  b1.setBackground(ColorDrawabler.white);
                b2.setText("Dont click me");
                b3.setText("Dont click me");
                b4.setText("Dont click me");
                break;
            case 1:
                b1.setText("Dont click me");
                b2.setText("click me");
                b3.setText("Dont click me");
                b4.setText("Dont click me");
                break;
            case 2:
                b1.setText("Dont click me");
                b2.setText("Dont click me");
                b3.setText("click me");
                b4.setText("Dont click me");
                break;
            case 3:
                b1.setText("Dont click me");
                b2.setText("Dont click me");
                b3.setText("Dont click me");
                b4.setText("click me");
                break;

        }


    }*/

    //jedes mal wenn ein button gepresst wird, soll überprüft werden ob es ein richtiger war
    //falls richtig, generiere neues level, score ++ und difficult ++
    //falls falsch game over
    public void btnpressed(View v){

    }

    //freezt das bild, bringt continue activity hervor auf er score und level zu sehen ist
    //high score mölgichkeiten
    public void gameOver(){

    }




    //    ListView lvItems;         lvItems =(ListView) findViewById(R.id.lvlitems);//hiermit hole ich mir mein listview in meinen JAva code

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_menue, menu);
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
