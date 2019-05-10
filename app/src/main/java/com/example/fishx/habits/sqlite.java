package com.example.fishx.habits;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqlite  extends SQLiteOpenHelper {

    public sqlite(Context c){
        super(c,"habits",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table habit (habitname text primary key,streak integer ,beststreak integer,happiness real,generalinfo text)";
        String sq2="create table habitDates (habitname text,date text, FOREIGN KEY(habitname) REFERENCES habit(habitname))";
        //String sql3="create table userHabtis(habitname text,userhabit integer)";//Userhabit boolean sqlitede olmadığından koyduğum integer 1-0 yerleştirin şimdilik iptalllllll amaa xdxd.
        db.execSQL(sql);
        db.execSQL(sq2);
        //db.execSQL(sql3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE  if exists habit");
        db.execSQL("DROP TABLE  if exists habitDates");

    }

}
