package com.example.portable.exercice_database2;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ChapitreDB {
    private static final int version = 1;
    private static final String nom_db = "Chapitre.db";
    private static final String tableChapitre = "tblChapitre";
    private static final String chapId  ="id";
    private static final int num_col_id = 0;
    private static final String chapName="name";
    private static final int num_col_name = 1;
    private static final String chapDescrip="description";
    private static final int num_col_descrip = 2;

    private SQLiteDatabase db;
    private ChapitreDataBase chapitre;

    public ChapitreDB(Context context){
        chapitre = new ChapitreDataBase(context, nom_db,version  );
    }

    public void  openForWrite(){
        db = chapitre.getWritableDatabase();
    }

    public void  openForRead(){
        db = chapitre.getReadableDatabase();
    }

    public void  close(){
        db.close();
    }

    public SQLiteDatabase getDb(){
        return db;
    }

    public long insertRow(Chapitre c){
        ContentValues content = new  ContentValues();
        content.put(chapName , c.getName());
        content.put(chapDescrip , c.getDescription());
        return db.insert(tableChapitre, null, content);
    }

    public int updateRow(int id, Chapitre c){
        db = chapitre.getWritableDatabase();
        ContentValues content = new  ContentValues();
        content.put(chapName , c.getName());
        content.put(chapDescrip , c.getDescription());
        return db.update(tableChapitre, content, chapId + " = " + id,null);
    }

    public int removeRow(String name){
       db = chapitre.getWritableDatabase();
       int isDelete = db.delete(tableChapitre, chapName + " = '" + name +"'", null);
       db.close();
       return isDelete;
    }

    public Chapitre cursorToChapiter(Cursor cu){
        if(cu.getCount()==0){
            cu.close();
            return null;
        }
        Chapitre ch =  new Chapitre();
        cu.moveToFirst();
        ch.setId(cu.getInt(num_col_id));
        ch.setName(cu.getString(num_col_name));
        ch.setDescription(cu.getString(num_col_descrip));
        cu.close();
        return ch;
    }

    public Chapitre getChapitre2(int id){

        db = chapitre.getReadableDatabase();

        Cursor cursor = db.query(tableChapitre,
                new String[]{chapId, chapName, chapDescrip},
                chapId + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();


        Chapitre ch =  new Chapitre(
                cursor.getInt(cursor.getColumnIndex(chapId)),
                cursor.getString(cursor.getColumnIndex(chapName)),
                cursor.getString(cursor.getColumnIndex(chapDescrip)));

        // close the db connection
        cursor.close();



        return ch;
    }

    public Chapitre getChapitre(String name){
        String[] listCols= new String[]{chapId, chapName, chapDescrip};
        String where =chapName + "like '"+ name +"'" ;
        String[] selectionArg=null;
        String groupBy=null;
        String having = null;
        String orderBy=chapName;
        db = chapitre.getReadableDatabase();

        Cursor cu = db.query(tableChapitre, listCols,where,selectionArg,groupBy,having, orderBy );
        cu.moveToFirst();
        return cursorToChapiter( cu);
    }

    public ArrayList<Chapitre > getAllRows(){
        String[] listCols= new String[]{chapId, chapName, chapDescrip};

        String where =null ;
        String[] selectionArg=null;
        String groupBy=null;
        String having = null;
        String orderBy=chapName;

        Cursor cu = db.query(tableChapitre, listCols,where,selectionArg,groupBy,having, orderBy );
        if(cu.getCount()==0){
            cu.close();
            return null;
        }
        ArrayList<Chapitre > listChapitres = new  ArrayList<Chapitre >();
        while (cu.moveToNext()) {
            Chapitre ch = new Chapitre();
            ch.setId(cu.getInt(num_col_id));
            ch.setName(cu.getString(num_col_name));
            ch.setDescription(cu.getString(num_col_descrip));
            listChapitres.add(ch);
        }
        cu.close();
        return listChapitres;

    }

}
