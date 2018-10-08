package codefactory.qc.com.exercise12;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ChapitreBD {
    private static final int VERSION = 1;
    private static final String NOM_BD = "Chapitre.db";
    private static final String TABLE_CHAPITRES = "table_chapitres";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_NAME = "NAME";
    private static final int NUM_COL_NAME = 1;
    private static final String COL_DESCRIPTION = "DESCRIPTION";
    private static final int NUM_COL_DESCRIPTION = 2;

    private SQLiteDatabase db;
    private ChapitreBaseSQLite chapitres;

    public ChapitreBD(Context context) {
        chapitres = new ChapitreBaseSQLite(context, NOM_BD, null, VERSION);
    }

    public void openForWrite() {
        db = chapitres.getWritableDatabase();
    }

    public void openForRead() {
        db = chapitres.getReadableDatabase();
    }

    public void close() {
        db.close();
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public long insertChapter(Chapitre chapitre){
        ContentValues content = new ContentValues();
        content.put(COL_NAME, chapitre.getName());
        content.put(COL_DESCRIPTION, chapitre.getDescription());
        return db.insert(TABLE_CHAPITRES, null, content);
    }


    public int updateChapter(int id, Chapitre chapitre){
        ContentValues content = new ContentValues();
        content.put(COL_NAME, chapitre.getName());
        content.put(COL_DESCRIPTION, chapitre.getDescription());
        return db.update(TABLE_CHAPITRES, content, COL_ID + " = " + id,null);
    }

    public int removeChapter(String name) {
        return db.delete(TABLE_CHAPITRES, COL_NAME + " = " + name, null);

    }

    public Chapitre getChapter(String name) {
        Cursor c = db.query(TABLE_CHAPITRES, new String[]{COL_ID, COL_NAME, COL_DESCRIPTION},
                COL_NAME + " like \"" + name + "\"", null, null, null, COL_NAME);
        return cursorToChapter(c);
    }

    private Chapitre cursorToChapter(Cursor c) {
        if (c.getCount() == 0) {
            c.close();
            return null;
        }
        Chapitre chapter = new Chapitre();
        chapter.setId(c.getInt(NUM_COL_ID));
        chapter.setName(c.getString(NUM_COL_NAME));
        chapter.setDescription(c.getString(NUM_COL_DESCRIPTION));
        c.close();
        return chapter;
    }

    public ArrayList<Chapitre> getAllChapters(){
        Cursor c = db.query(TABLE_CHAPITRES, new String[]{COL_ID, COL_NAME, COL_DESCRIPTION},
                null, null, null, null, COL_NAME);
        if(c.getCount()== 0){
            c.close();
            return null;
        }
        ArrayList<Chapitre> chapterList = new ArrayList<Chapitre>();
        while (c.moveToNext()){
            Chapitre chapter = new Chapitre();
            chapter.setId(c.getInt(NUM_COL_ID));
            chapter.setName(c.getString(NUM_COL_NAME));
            chapter.setDescription(c.getString(NUM_COL_DESCRIPTION));
            chapterList.add(chapter);
        }
        c.close();
        return chapterList;
    }




}//End of the Class

