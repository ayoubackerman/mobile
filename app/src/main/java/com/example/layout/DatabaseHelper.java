package com.example.layout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "rendez_vous.db";
    private static final int DATABASE_VERSION = 2;  // Update version due to schema change

    public static final String TABLE_RENDEZ_VOUS = "rendez_vous";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_STATUS = "status";
    public static final String COLUMN_URGENT = "urgent";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_RENDEZ_VOUS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_DATE + " TEXT, " +
                    COLUMN_TIME + " TEXT, " +
                    COLUMN_DESCRIPTION + " TEXT, " +
                    COLUMN_STATUS + " TEXT, " +
                    COLUMN_URGENT + " INTEGER);";  // INTEGER to store boolean (1 for true, 0 for false)

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RENDEZ_VOUS);
        onCreate(db);
    }
}
