package ScoreDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kelvin on 21-11-2016.
 */

public class ScoreDB extends SQLiteOpenHelper {
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Score (Name VARCHAR (10), Score INT, Id INT PRIMARY KEY);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ScoreDB(Context c){
        super(c,"db", null, 1);
    }
}
