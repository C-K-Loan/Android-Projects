package com.example.loan.fastclickerv30;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

// HIER WIRD ALLES GEHANDELT WAS AUUF DEM GAMESCREEN PASSIERT

//alle buttons einrichten

/**todo:
 * Interface bauen mit maßblatt
 *      4 buttons
 *       Irgendwas für score
 *       IRgendwas für time
 *       werbefläche lol?+
 *
 *
 *       //TODO BETA
 *       Wie schicke ich zwischen Intents Variablen? ich muss vom Game_screen zum Game_OVer Screen den Score schicken und Speicchern
 *       Variablen speichern-> SQL LITE?(score einspeichern, sodass nach dem  app neustart sich gemerkt wird wo man war)
 *       die Unteren Back/home Buttons ausblenden
 *       Andere GFX GRPAHCISXXXX (geld Scheine sammeln?)
 *       Das Game Layout nochmal bissel bearbeiten, die kacke ist unsymm
 *       WEnn das Alles done, ist das spiel fertig?!?!??!
 *
 *          Style Ideas
 *              Chachiiiingg Sound jedes mal wenn man geld aufhebt (Vll 3x hunde kacke 1X geld, sodass man wortwürtlich in die scheisse greift lol)
 *              Das Geld das man sammelt kann man im Shop für sachen ausgeben( %mehr Geld das auf den Plattformen liegt, mehr Zeit, weniger Scheisse lol etc/ vll andere Level Skins, sodass man einen Club hat und danced statt geld aufsammelt)

 *
 *  richtige grafik assets bekommen
 *  musik:
 *      klick sound
 *      background music
 *
 * startscreen mal pimepn
 *  
 *
 * thread in der main implementieren
 *
 * Design Idea:
 * dough collector
 its dollars you collect, statt buttons drücken hebt man dollars auf(die logig ist dennoch immer noch buttons )
 *
 *
 * GAme_Over Conditions :
 * Time_UP : TImeleft erreicht 0
 * misspress : Falscher Button gedrückt
 */


public class Game_Screen extends ActionBarActivity {
    public Thread game_setter,time_setter;  //game_setter ändert das level immer, sobald das ein button gepressed wurde , Timesetter update die Zeit auf dem LAbel und überprüft die Game_Over COndition TIME_UP
    public int lives,hit;
    public ImageButton b1,b2,b3,b4;
    public int[] curr_layout;
    public TextView score_TV,time_TV;
    public int score;
    Intent game_Over,intent;
    public  MediaPlayer game_over_MP,click1,click2,click3,click4,click5,click6,click7;
    float time_left;//not implemented
    public Thread timer_Thread;
    public Runnable runner;
    public CharSequence time_cs;
    public Boolean game_Over_Bool;
    public double  a,b,initialTime;
    public CountDownTimer timer;

    //game over Funktion, wechselt die Activity auf die Game over Activity
    public void gameOver(){
        startActivity(intent);
        //game_over_MP.start();
    }


    public void update_Time_TV(double time){
        time_TV.setText(String.valueOf(time));//update label

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_menue);

        View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        intent = new Intent(this, Game_Over_activity.class);
        game_Over_Bool=true;
        //Game Balance Variable !
        time_left = 5;            //wieviel Zeit initial da ist, Eventuell als int array deklarieren, sodass die nächsten level
        lives = 3;
        initialTime=5000;
        curr_layout = new int[4];
        curr_layout[0] = -1;
        curr_layout[1] = -1;
        curr_layout[2] = -1;
        curr_layout[3] = -1;

        game_over_MP = MediaPlayer.create(this, R.raw.game_over);
        click1 = MediaPlayer.create(this, R.raw.click1);
        click2 = MediaPlayer.create(this, R.raw.click2);
        click3 = MediaPlayer.create(this, R.raw.click3);
        click4 = MediaPlayer.create(this, R.raw.click4);
        click5 = MediaPlayer.create(this, R.raw.click5);
        click6 = MediaPlayer.create(this, R.raw.click6);
        click7 = MediaPlayer.create(this, R.raw.click7);

        time_TV = (TextView) findViewById(R.id.time_TV);

        b1 = (ImageButton) findViewById(R.id.imbttn1);
        b2 = (ImageButton) findViewById(R.id.imbttn2);
        b3 = (ImageButton) findViewById(R.id.imbttn3);
        b4 = (ImageButton) findViewById(R.id.imbttn4);
        //ab hier sind Variablen setups done

        //init Timer Thread


        //init Level
        generate_Level();
        score_TV = (TextView) findViewById(R.id.score_TV);
        score = 0;

         //if (Double.parseDouble(time_TV.getText().toString()) > 0) {// diese Bedingung holt sich die momentan angezeigte Zeit, wandelt sie in einen double und schaut ob es 0 ist

        //  Thread timer_Thread = new Thread((new timer_Runnable(time_TV)));

      /**  runner = new Runnable() {

            public void run() {
                    time_TV.setText(time_cs);



            }
        };
     //   time_TV.post(runner);

        game_Over_Bool=true;
        time_left=100;

        Thread t= new Thread(new Runnable() {
                public void run() {


                            while(a !=10) {// ohne schleife gehts, mit aber nicht..

                                //set up next time
                                time_TV.post(runner);
                               // Thread.sleep(100000);
                                time_left++;
                                a++;

                        }



                }



       });
**/


        a=initialTime;
        b=200;



        timer= new CountDownTimer(500000, 100) {// der timer geht 5000ms, danach wird on Finish gecallt(game over)    alle 100ms wird on Tick gecallt, das ist würd label updates zuständig
                                                //wenn einer der Buttons richtig gecallt wird wird der aktuellte timer gekillt und direkt ein neuer gestartet

            //definition was der timer macht
            public void onTick(long millisUntilFinished) {//on tick

                if(game_Over_Bool== false ) onFinish();
                time_TV.setText(" "+a);
                a= a-100;
                if(a<0){ timer.cancel(); onFinish();}

            }

            public void onFinish() {// time is up u failed
                gameOver();

            }
        };



//button clicks config

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSound();
                check_win_cond(b1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                clickSound();
                check_win_cond(b2);
            }
        });


        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                clickSound();
                check_win_cond(b3);
            }
        });


        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                clickSound();

                check_win_cond(b4);
            }
        });

        //t.run();

    }


    public void restart_Timer() {
        a=initialTime;
        initialTime-=200;
        game_Over_Bool=true;
        timer.cancel();
        timer.start();
    }


    //FUNKTION DIE gecallt wird wenn einer der Buttons gepresst wird
    public void check_win_cond(View v){

        if(v==b1 ){
           if (curr_layout[0]==0){ gameOver(); game_Over_Bool=true;}


        }else if (v==b2){
            if (curr_layout[1]==0) { gameOver(); game_Over_Bool=true;}


        }else if (v==b3){
            if (curr_layout[2]==0) { gameOver(); game_Over_Bool=true;}


        }else if (v==b4){
            if (curr_layout[3]==0) { gameOver(); game_Over_Bool=true;}

        }
        //wenn durch allle if cases, dann heißt das richtier button gepresst!
        game_Over_Bool=false;
        score++;
        score_TV.setText((Integer.toString(score)));
        restart_Timer();
        generate_Level();
        }




    //Diese FUnktion generiet das LEvel
    public void generate_Level(){

        Random level = new Random();
        //generiere seed für level
        int levelLayout = level.nextInt(4);

        switch(levelLayout){
            case 0:
                b1.setImageResource(R.drawable.yes);
                b2.setImageResource(R.drawable.no);
                b3.setImageResource(R.drawable.no);
                b4.setImageResource(R.drawable.no);
                curr_layout[0]= 1;
                curr_layout[1]= 0;
                curr_layout[2]= 0;
                curr_layout[3]= 0;
                break;
            case 1:

                b1.setImageResource(R.drawable.no);
                b2.setImageResource(R.drawable.yes);
                b3.setImageResource(R.drawable.no);
                b4.setImageResource(R.drawable.no);
                curr_layout[0]= 0;
                curr_layout[1]= 1;
                curr_layout[2]= 0;
                curr_layout[3]= 0;
                break;
            case 2:

                b1.setImageResource(R.drawable.no);
                b2.setImageResource(R.drawable.no);
                b3.setImageResource(R.drawable.yes);
                b4.setImageResource(R.drawable.no);
                curr_layout[0]= 0;
                curr_layout[1]= 0;
                curr_layout[2]= 1;
                curr_layout[3]= 0;
                break;
            case 3:

                b1.setImageResource(R.drawable.no);
                b2.setImageResource(R.drawable.no);
                b3.setImageResource(R.drawable.no);
                b4.setImageResource(R.drawable.yes);
                curr_layout[0]= 0;
                curr_layout[1]= 0;
                curr_layout[2]= 0;
                curr_layout[3]= 1;
                break;
        }

    }


    //soud handling
    public void clickSound(){
        Random sound = new Random();
        int soundNr = sound.nextInt(7);

        switch(soundNr){
            case 0:
                click1.start();

                break;
            case 1:
                click2.start();

                break;

            case 2:
                click2.start();

                break;

            case 3:
                click3.start();


                break;

            case 4:
                click4.start();


                break;

            case 5:
                click5.start();

                break;

            case 6:
                click6.start();

                break;

            case 7:
                click7.start();

                break;

        }

        }



}
