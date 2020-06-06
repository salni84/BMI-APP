package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.util.ArrayList;


public class DatabaseAdapter {

    private static final int databaseVersion = 1;
    private static final String databaseName = "data";
    private static final String tableName = "BMI";

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;


    public DatabaseAdapter (Context context){
        databaseHelper = new DatabaseHelper (context, databaseName, null, databaseVersion);
    }

    public void open(){
        database = databaseHelper.getWritableDatabase();
    }

    public void insertData(String datum, String name, String groesse, String gewicht){
        ContentValues values = new ContentValues();
        values.put("datum", datum);
        values.put("name", name);
        values.put("groesse", groesse);
        values.put("gewicht", gewicht);
        database.insert(tableName, null, values);
    }


    ArrayList<String> selectData(){


        ArrayList<String> arrayList = new ArrayList<>();
        String[] columns = {"*"};
        String entry;

        Cursor result = database.query(tableName, columns, null, null, null, null, null);
        result.moveToFirst();


        while (!result.isAfterLast()){
            String date = result.getString(result.getColumnIndex("datum"));
            String name = result.getString(result.getColumnIndex("name"));
            String groesse = result.getString(result.getColumnIndex("groesse"));
            String gewicht = result.getString(result.getColumnIndex("gewicht"));

            entry = date + ", " + name + ", " + groesse + ", " + gewicht;

            arrayList.add(entry);
            result.moveToNext();
        }
        result.close();
        return arrayList;
    }


    private static class DatabaseHelper extends SQLiteOpenHelper{


        private static final String createTablesQuery
                = String.format("CREATE TABLE IF NOT EXISTS %s (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " datum TEXT, name TEXT, groesse TEXT, gewicht TEXT);", tableName);

        private static final String dropTablesQuery = String.format("DROP TABLE IF EXISTS %s;", tableName);

        public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context, name, factory, version);
        }

        @Override
        public void onCreate (SQLiteDatabase database){
            database.execSQL(createTablesQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
            database.execSQL(dropTablesQuery);
            onCreate(database);
        }
    }
}
