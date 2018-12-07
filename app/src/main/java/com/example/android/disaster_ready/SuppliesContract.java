package com.example.android.disaster_ready;

import android.provider.BaseColumns;

/*
 * This class defines the database schema to be used for the
 * emergency supplies database, which will be used for persistent
 * storage of original and user-created item.
 */
public final class SuppliesContract {

    /*
     * Prevent instantiation of the Supplies_Contract
     * database schema class
     */
    private SuppliesContract(){};
    /*
     * Nested class to represent the schema for
     * the items table in the Supplies database
     */
    public static class DefaultItems implements BaseColumns {

        public static final String TABLE_NAME = "DefaultItems";             //name of the table
        public static final String COLUMN_NAME = "Item";                    //name of the first attribute
        public static final String COLUMN_WEIGHT = "Weight";                //name of the second attribute
        public static final String COLUMN_QUANTITY =  "Quantity";           //name of the third attribute
        public static final String COLUMN_DESCRIPTION = "Description";      //name of the final attribute
    }

    /*
     * Nested class to represent the schema for
     * the user-defined items table in the database
     */
    public static class UserItems implements BaseColumns {

        public static final String TABLE_NAME = "UserItems";                //name of the table
        public static final String COLUMN_NAME = "Name";                    //name of the first attribute
        public static final String COLUMN_WEIGHT = "Weight";                //name of the second attribute
        public static final String COLUMN_QUANTITY =  "Quantity";           //name of the third attribute
        public static final String COLUMN_DESCRIPTION = "Description";      //name of the final attribute
    }

    /*
     * SQL query to create the user-item table
     * in the database, per the DefaultItems schema
     */
    public static final String CREATE_DEFAULT_ITEMS = "CREATE TABLE " +
            DefaultItems.TABLE_NAME + "(" + DefaultItems._ID +
            " INTEGER PRIMARY KEY, " + DefaultItems.COLUMN_NAME +
            " TEXT, " + DefaultItems.COLUMN_WEIGHT +
            " TEXT, " + DefaultItems.COLUMN_QUANTITY +
            " TEXT, " + DefaultItems.COLUMN_DESCRIPTION +
            " TEXT )";

    /*
     * SQL query to create the user-item table
     * in the database, per the UserItems schema
     */
    public static final String CREATE_USER_ITEMS = "CREATE TABLE " +
            UserItems.TABLE_NAME + "(" + UserItems._ID +
            " INTEGER PRIMARY KEY, " + UserItems.COLUMN_NAME +
            " TEXT, " + UserItems.COLUMN_WEIGHT +
            " TEXT, " + UserItems.COLUMN_QUANTITY +
            " TEXT, " + UserItems.COLUMN_DESCRIPTION +
            " TEXT )";

    /*
     * SQL query to drop the default item table
     * in the database
     */
    public static final String DELETE_DEFAULT_ITEMS =
            "DROP TABLE IF EXISTS " +  DefaultItems.TABLE_NAME;

    /*
     * SQL query to drop the user item table
     * in the database
     */
    public static final String DELETE_USER_ITEMS =
            "DROP TABLE IF EXISTS " +  DefaultItems.TABLE_NAME;

}
