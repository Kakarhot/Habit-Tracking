package com.example.android.habittracking;

/**
 * Created by wenshuo on 2016/10/10.
 */

import android.provider.BaseColumns;

public final class HabitContract {

    private HabitContract(){}

    public static final class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habits";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_HABIT_NAME = "name";
        public static final String COLUMN_HABIT_COUNT = "count";
        public static final String COLUMN_HABIT_DATE_LAST_DONE = "dateLastDone";
    }
}
