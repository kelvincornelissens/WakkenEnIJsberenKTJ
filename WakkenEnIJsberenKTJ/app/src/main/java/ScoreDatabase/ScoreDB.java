package ScoreDatabase;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Kelvin on 21-11-2016.
 */

public class ScoreDB extends SQLiteOpenHelper {

    private SQLiteDatabase database;

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Score (Name VARCHAR (10), Score INT, Id INT PRIMARY KEY);");
        this.database = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ScoreDB(Context c) {
        super(c, "db", null, 1);
    }


    public void Add(Score score) {
        String name = score.getName();
        int punten = score.getScore();

        database.execSQL("INSERT INTO Score(Name, Score) VALUES(" + name + ", " + punten + ");");
    }
}
