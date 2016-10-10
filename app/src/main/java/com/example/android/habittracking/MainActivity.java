package com.example.android.habittracking;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void insertRecord(ContentValues values) {
        HabitDbHelper habitDbHelper = new HabitDbHelper(this);

        SQLiteDatabase database = habitDbHelper.getWritableDatabase();
        database.insert(HabitContract.HabitEntry.TABLE_NAME,null,values);
    }

    public Cursor queryRecord(int id) {
        HabitDbHelper habitDbHelper = new HabitDbHelper(this);

        String[] projection = {
                HabitContract.HabitEntry.COLUMN_HABIT_NAME,
                HabitContract.HabitEntry.COLUMN_HABIT_COUNT,
                HabitContract.HabitEntry.COLUMN_HABIT_DATE_LAST_DONE
        };

        String selection = HabitContract.HabitEntry._ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(id)};

        SQLiteDatabase database = habitDbHelper.getReadableDatabase();
        Cursor cursor = database.query(HabitContract.HabitEntry.TABLE_NAME,projection,selection,selectionArgs,null,null,null);
        return cursor;
    }
}
