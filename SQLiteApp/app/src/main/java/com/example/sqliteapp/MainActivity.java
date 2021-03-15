package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    StudentDatabaseHelper studentDatabaseHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentDatabaseHelper = new StudentDatabaseHelper(this);
        db = studentDatabaseHelper.getWritableDatabase();
    }

    public void insertStudent(View view) {

        Button btnSubmit = (Button) findViewById(R.id.btn_submit);
        EditText etUsername = (EditText) findViewById(R.id.etUsername);
        ContentValues values = new ContentValues();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etUsername.getText().toString();
                Intent intent = new Intent(getApplicationContext(),SuccessActivity.class);
                if (userName != null) {
                    values.put("name", userName);
                    db.insert("student", null, values);
                    Log.i("MAINACTIVITY", "Username is inserted");
                    intent.putExtra("Success","Username inserted successfully");
                    startActivity(intent);

                } else {
                    Log.i("MAINACTIVITY", "Username is empty");
                }
            }
        });
    }
}