package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.waitlist.data.WaitlistContract.WaitlistEntry;

// TODO (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {

    // TODO (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"

    public static final String DATABASE_NAME = "waitlist.db";
    public static final int  DB_VERSION =1;
    public static final String SQL_CREATE_WAITLIST_TABLE =
            "create table "+ WaitlistEntry.TABLE_NAME+" ( "+WaitlistEntry._ID+" integer primary key autoincrement, "
            +WaitlistEntry.COLUMN_GUEST_NAME+" text not null, "+WaitlistEntry.COLUMN_PARTY_SIZE+" integer not null,"
            +WaitlistEntry.COLUMN_TIMESTAMP+" timestamp default current_timestamp );";
    // TODO (3) Create a static final int called DATABASE_VERSION and set it to 1

    public WaitlistDbHelper(Context context){
        super(context,DATABASE_NAME,null,DB_VERSION);
    }

    // TODO (4) Create a Constructor that takes a context and calls the parent constructor

    // TODO (5) Override the onCreate method

        // TODO (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table

        // TODO (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+WaitlistEntry.TABLE_NAME);
        onCreate(db);
    }

    // TODO (8) Override the onUpgrade method

        // TODO (9) Inside, execute a drop table query, and then call onCreate to re-create it

}