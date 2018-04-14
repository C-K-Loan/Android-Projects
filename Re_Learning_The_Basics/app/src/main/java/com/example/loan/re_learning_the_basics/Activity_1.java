package com.example.loan.re_learning_the_basics;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Activity_1 extends ActionBarActivity {

    Button login_B;
    int i;

    EditText name_Edit,password_Edit;
    Intent openNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_1);

        //Setting up shit
        name_Edit= (EditText)findViewById(R.id.editText);
        password_Edit=(EditText)findViewById(R.id.editText2);
        String name_Edit_Text;
        openNewActivity= new Intent(getApplicationContext(), TweetListActivity.class);




        name_Edit.setText("yo wassuop this shit work",null);
        name_Edit_Text=name_Edit.getText().toString();
        password_Edit.setText(name_Edit_Text);


        i =0;
        login_B = (Button) findViewById(R.id.login_Button);
        login_B.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(openNewActivity);              }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_1, menu);
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
