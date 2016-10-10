package com.example.android.habittracking;

/**
 * Created by wenshuo on 2016/10/10.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class HabitDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = HabitDbHelper.class.getSimpleName();

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "habit.db";


    public HabitDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE " + HabitContract.HabitEntry.TABLE_NAME + " ("
                + HabitContract.HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitContract.HabitEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitContract.HabitEntry.COLUMN_HABIT_DATE_LAST_DONE + " TEXT, "
                + HabitContract.HabitEntry.COLUMN_HABIT_COUNT + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + HabitContract.HabitEntry.TABLE_NAME;
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
