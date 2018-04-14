package com.example.loan.fastclickerv30;

/**
 * Created by loan on 07.08.16.
 */
// TODO ALL THE IMPORTS

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//TODO save the scores in the database and update them
public class DB_Handler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "score_DB";

    // Contacts table name
    private static final String TABLE_SCORE = "scores";

    // Contacts Table Columns names
    private static final String KEY_ID = "id"; //pos
    private static final String KEY_NAME = "name";
    private static final Integer KEY_TAPS = 0;
    private static final Double KEY_TIME_LEFT=2.22;


    //constructor
    public DB_Handler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    //THIS IS NECCECRARY OVERRIDE
    // called to initilize the db
    @Override
    public void onCreate(SQLiteDatabase db) {

        String Score_Table_String = "CREATE TABLE " + TABLE_SCORE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_TAPS + " INTEGER,"
                + KEY_TIME_LEFT + "DOUBLE)";
        db.execSQL(Score_Table_String);

    }

    //same as above
    //called to update db
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // SQLiteDatabase mydatabase = openOrCreateDatabase("your database name",MODE_PRIVATE,null);
}
