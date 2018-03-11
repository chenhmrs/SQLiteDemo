package com.example.jdsm.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper=new MyDatabaseHelper(this,"BookStore",null,1);
        dbHelper.getWritableDatabase();
    }
}
