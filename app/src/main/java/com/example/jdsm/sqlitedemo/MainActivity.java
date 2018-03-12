package com.example.jdsm.sqlitedemo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    public MyDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dbHelper = new MyDatabaseHelper(this, "BookStore.db", null, 2);

    }

    @OnClick({R.id.button_create, R.id.button_insert, R.id.button_update, R.id.button_delete, R.id.button_query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_create:
                dbHelper.getWritableDatabase();
                break;
            case R.id.button_insert:
                SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put("name","Book1");
                values.put("author","A");
                values.put("pages",454);
                values.put("price",16.69);
                db.insert("Book",null,values);
                values.clear();
                values.put("name","Book2");
                values.put("author","B");
                values.put("pages",124);
                values.put("price",12.25);
                db.insert("Book",null,values);
                break;
            case R.id.button_update:
                SQLiteDatabase db1=dbHelper.getWritableDatabase();
                ContentValues values1=new ContentValues();
                values1.put("price",10.99);
                db1.update("Book",values1,"name= ?",new String[]{"Book2"});
                break;
            case R.id.button_delete:
                SQLiteDatabase db2=dbHelper.getWritableDatabase();
                db2.delete("Book","pages> ?",new String[]{"400"});
                break;
            case R.id.button_query:
                break;
        }
    }
}
