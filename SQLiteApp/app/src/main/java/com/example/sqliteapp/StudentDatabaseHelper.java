package com.example.sqliteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StudentDatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASENAME = "student.db";
    private static int DATABASEVERSION = 1;

    public StudentDatabaseHelper(@Nullable Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE student(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT);");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
