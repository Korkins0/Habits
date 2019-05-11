package com.example.fishx.habits;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class SQLiteAdapter extends SQLiteOpenHelper {

    private static final String database_NAME = "habitDB";
    private static final int database_VERSION = 1;
    private static final String table_HABIT = "habitContentDB";
    private static final String table_DATE = "dateDB";
    private static final String hatirlanacak_HABIT = "content";
    private static final String hatirlanacak_ID = "id";
    private static final String hatirlanacak_STREAK = "streak";
    private static final String hatirlanacak_BESTSTREAK = "beststreak";
    private static final String hatirlanacak_HAPPINESS = "happiness";
    private static final String hatirlanacak_NOTIF = "notif";
    private static final String hatirlanacak_DATE = "date";
    private static final String COLUMNS[] = { hatirlanacak_ID ,hatirlanacak_HABIT  , hatirlanacak_STREAK , hatirlanacak_BESTSTREAK ,
            hatirlanacak_HAPPINESS ,  hatirlanacak_NOTIF};
    private static final String CREATE_TODOTABLE = "CREATE TABLE " + table_HABIT +" (" +
            hatirlanacak_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            hatirlanacak_HABIT +" TEXT, " +
            hatirlanacak_STREAK +" INTEGER, " +
            hatirlanacak_BESTSTREAK +" INTEGER, " +
            hatirlanacak_HAPPINESS +" REAL, " +
            hatirlanacak_NOTIF +" TEXT " +
            ");";
    private static final String CREATE_DATETABLE = "CREATE TABLE " + table_DATE +" (" +
            hatirlanacak_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
            hatirlanacak_DATE +" TEXT " +
            ");";


    public SQLiteAdapter(Context context) {
        super(context, database_NAME, null, database_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TODOTABLE);
        db.execSQL(CREATE_DATETABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void dateAdd(habitAdapter contentValue){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(hatirlanacak_DATE,contentValue.getHabit());;
        db.insert(table_DATE,null,values);
        db.close();
    }
    public void contentAdd(habitAdapter contentValue){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(hatirlanacak_HABIT,contentValue.getHabit());
        values.put(hatirlanacak_STREAK,contentValue.getStreak());
        values.put(hatirlanacak_BESTSTREAK,contentValue.getBeststreak());
        values.put(hatirlanacak_HAPPINESS,contentValue.getHappiness());
        values.put(hatirlanacak_NOTIF,contentValue.getNotif());
        db.insert(table_HABIT,null,values);
        db.close();
    }
    public List<habitAdapter> getContents(){
        List<habitAdapter> listeler = new ArrayList<>();
        String query = " SELECT * FROM "+table_HABIT;
        SQLiteDatabase db = this.getReadableDatabase();
        habitAdapter liste = null;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {
                liste = new habitAdapter();
                liste.setId(Integer.parseInt(cursor.getString(0)));
                liste.setHabit(cursor.getString(1));
                liste.setStreak(Integer.parseInt(cursor.getString(2)));
                liste.setBeststreak(Integer.parseInt(cursor.getString(3)));
                liste.setHappiness(Float.parseFloat(cursor.getString(4)));
                liste.setNotif(Integer.parseInt(cursor.getString(5)));
                listeler.add(liste);
            }while (cursor.moveToNext());
        }
        return listeler;
    }

}
