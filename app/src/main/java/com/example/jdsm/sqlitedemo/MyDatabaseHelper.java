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
             + "author text, "
             + "price real,"
             + "pages integer,"
             + "name text )";
     public static final String CREATE_CATEGORY="create table Category("
             +"id integer primary key autoincrement,"
             +"category_name text,"
             +"category_code integer)";
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
        //在数据库中添加表，不写就只有数据库无表
        db.execSQL(CREATE_BOOK);
        db.execSQL(CREATE_CATEGORY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //onCreate只会执行一次，除非在onUpgrade里再次调用，所以删除以前的表
        db.execSQL("drop table if exists Book");
        db.execSQL("drop table if exists Category");
        onCreate(db);
    }
}
