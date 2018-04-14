package com.example.loan.fastclickerrerework;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by loan on 23.04.15.
 */
public class menue extends Activity {

    @Override
    protected void onPause() {
        super.onPause();
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
