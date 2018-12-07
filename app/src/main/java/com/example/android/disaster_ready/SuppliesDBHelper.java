package com.example.android.disaster_ready;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

/*
 * This class is used to implement database functions
 * to manage the supply database, the structure of
 * which is defined by the SuppliesContract class
 */
public class SuppliesDBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;                     //database version
    public static final String SUPPLIES_DB_NAME = "Supplies";   //name of the database

    // CONSTRUCTOR //
    public SuppliesDBHelper(Context context) {
        super(context, SUPPLIES_DB_NAME, null, DB_VERSION);
    }
    /*
     * On create, this method will create the tables
     * of the supplies database
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SuppliesContract.CREATE_DEFAULT_ITEMS);  //create default items table
        db.execSQL(SuppliesContract.CREATE_USER_ITEMS);     //create user-defined items table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop outdated tables on upgrade
        if(oldVersion != newVersion) {
            db.execSQL(SuppliesContract.DELETE_DEFAULT_ITEMS);  //drop default items table
            db.execSQL(SuppliesContract.DELETE_USER_ITEMS);     //drop user-defined items table
            onCreate(db);   //create updated database

        }
    }
}
