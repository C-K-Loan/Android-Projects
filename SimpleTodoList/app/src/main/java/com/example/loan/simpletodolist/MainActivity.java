package com.example.loan.simpletodolist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    ArrayList<String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {// das läd das xml layout in die activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItems =(ListView) findViewById(R.id.lvlitems);//hiermit hole ich mir mein listview in meinen JAva code
                                                        // ich deklariere ich habe eine <neue variable von typen Listview namens lvItems
                                                        // ich sage er findet mein"view" unter R.id.lvitems, also unter der Id die ich festgelegt habe

       items=new ArrayList<String>();
       itemsAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, items);
       lvItems.setAdapter(itemsAdapter);
       items.add("first item");
       items.add("second item");
    }

    public void onAddItem(View v){
        EditText etNewItem = (EditText)findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
