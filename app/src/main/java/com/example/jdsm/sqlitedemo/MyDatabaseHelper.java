package com.example.jdsm.sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jdsm on 2018/3/11.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper{
     private Context mContext;
     public static final String CREATE_BOOK="create table Book ( "
             + "id integer primary key autoincrement, "
             + "auto text, "
             + "price real"
             + "pages integer"
             + "name text )";
    /**
     *
     * @param context 估计最好用application的
     * @param name 数据库名字
     * @param factory  未知
     * @param version
     */
    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
