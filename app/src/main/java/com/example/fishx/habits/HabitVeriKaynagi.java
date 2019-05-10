package com.example.fishx.habits;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class HabitVeriKaynagi {

    SQLiteDatabase db;
    sqlite bdb;

    public HabitVeriKaynagi(Context c){
        bdb=new sqlite(c);
    }

    public void ac(){
        db=bdb.getWritableDatabase();
    }

    public void kapat(){
        bdb.close();
    }




}
