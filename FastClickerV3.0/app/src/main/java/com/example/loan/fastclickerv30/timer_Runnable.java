package com.example.loan.fastclickerv30;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by loan on 25.08.15.
 */



public class timer_Runnable extends ActionBarActivity implements  Runnable   {

    public double time_left;
    public TextView time_TV;

   public   timer_Runnable(TextView tv){

       time_TV=tv;
       time_left=5.000;

   }


    public void run() {     //run code für den timer Threads
        //if (Double.parseDouble(time_TV.getText().toString()) > 0) {// diese Bedingung holt sich die momentan angezeigte Zeit, wandelt sie in einen double und schaut ob es 0 ist
        while (1==1) {
            time_left -= 0.001;                           //änder value
            time_TV.setText(String.valueOf(time_left));//update label
            //  }
            try {
                 Thread .sleep(100);
            } catch (InterruptedException ie) {
             }
        }
    }



}