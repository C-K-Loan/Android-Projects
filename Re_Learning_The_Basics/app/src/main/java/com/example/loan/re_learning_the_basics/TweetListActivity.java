package com.example.loan.re_learning_the_basics;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TweetListActivity extends Activity {
    ListView tweet_List_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_list);
        String[] codeLearnChapters = new String[] { "Android Introduction","Android Setup/Installation","Android Hello World","Android Layouts/Viewgroups","Android Activity & Lifecycle","Intents in Android"};
        tweet_List_View= (ListView) findViewById(R.id.tweet_LV);

        //das ist ein Adapter, der meine Daten in mein Listview reinsteckt
        //1.Parameter Context, 2. Parameter ist das Layout, inwelchem meine Listelemente ausgelegt werden 3. Parameter sidn die Daten, in dem Fall strings für die Liste
        ArrayAdapter<String> codeLearnArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, codeLearnChapters);

        tweet_List_View.setAdapter(codeLearnArrayAdapter);

    }


}
