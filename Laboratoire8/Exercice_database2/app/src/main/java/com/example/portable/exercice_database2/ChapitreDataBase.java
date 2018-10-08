package com.example.portable.exercice_database2;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChapitreDataBase extends SQLiteOpenHelper {
    private static final String tableChapitre = "tblChapitre";
    private static final String chapId  ="id";
    private static final String chapName="name";
    private static final String chapDescrip="description";

    private static final String creaTblChapitre="create table " + tableChapitre + " ("+
            chapId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            chapName + " TEXT NOT NULL, " + chapDescrip + "  TEXT NOT NULL ); "
            ;
    public ChapitreDataBase (Context context, String name, int version){
        super(context,name, null, version);
    }

    public void onCreate (SQLiteDatabase db){
        db.execSQL(creaTblChapitre);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("drop table " + tableChapitre);
        onCreate(db);
    }




}