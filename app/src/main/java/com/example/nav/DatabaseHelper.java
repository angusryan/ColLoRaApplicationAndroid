package com.example.nav;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "users.db";
    public static final String TABLE_NAME = "account_data";
    public static final String TABLE_NAME2 = "device";
    public static final String table1Col1 = "email";
    public static final String table1Col2 = "password";
    public static final String table1Col3 = "firstName";
    public static final String table1Col4 = "lastName";
    public static final String table2Col1 = "device_ID";
    public static final String table2Col2 = "lat";
    public static final String table2Col3 = "lon";


    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    //Creates table and determines table key
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "("

        + table1Col1 + " TEXT PRIMARY KEY,"
        + table1Col2 + " TEXT,"
        + table1Col3 + " TEXT,"
        + table1Col4 + " TEXT" + ")";
        db.execSQL(createTable);

        String createTable2 = "CREATE TABLE " + TABLE_NAME2 + "("

                + table2Col1 + " TEXT PRIMARY KEY,"
                + table2Col2 + " TEXT,"
                + table2Col3 + " Text"
                + ")";
        db.execSQL(createTable2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME );
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME2 );

        onCreate(db);
    }


    //Registers new user
    public boolean addData(String email, String password, String firstName, String lastName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(table1Col1, email);
        contentValues.put(table1Col2, password);
        contentValues.put(table1Col3, firstName);
        contentValues.put(table1Col4, lastName);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    //Adds data for device and location into database
    public boolean addDeviceData( String deviceId, String lat, String lon) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(table2Col1, deviceId);
        contentValues.put(table2Col2, lat);
        contentValues.put(table2Col3, lon);


        long result = db.insert(TABLE_NAME2, null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    //grabs database contents of user table
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    //Checks user login
    public boolean keyCheck(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                // Do whatever you like with the result.

                if (cursor.getString(0).equals(username) && cursor.getString(1).equals(password)){
                    cursor.moveToLast();
                    System.out.println("If pass " );

                    return true;
                }
                else{
                    System.out.println("else fail");
                    

                }
                cursor.moveToNext();
            }
        }
        return false;
    }

}