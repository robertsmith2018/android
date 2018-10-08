package codefactory.qc.com.exercise12;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ChapitreBaseSQLite extends SQLiteOpenHelper {

    private static final String TABLE_CHAPITRES = "table_chapitres";
    private static final String COL_ID ="ID";
    private static final String COL_NAME = "NAME";
    private static final String COL_DESCRIPTION = "DESCRIPTION";

    private static final String CREATE_DB = "CREATE TABLE " + TABLE_CHAPITRES + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " TEXT NOT NULL, " + COL_DESCRIPTION + "TEXT NOT NULL );";
    public ChapitreBaseSQLite(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_CHAPITRES);
        onCreate(db);
    }
}
