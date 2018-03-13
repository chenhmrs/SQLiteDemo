package com.example.jdsm.sqlitedemo.ContentProviderCustom;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.jdsm.sqlitedemo.MyDatabaseHelper;

/**
 * Created by Well Wang on 2018/3/13.
 */

public class PeopleContentProvider extends ContentProvider {

    //这里的AUTHORITY就是我们在AndroidManifest.xml中配置的authorities，这里的authorities可以随便写
    private static final String AUTHORITY = "com.example.studentProvider";
    //匹配成功后的匹配码
    private static final int MATCH_ALL_CODE = 100;
    private static final int MATCH_ONE_CODE = 101;
    private static UriMatcher mUriMatch;
    private SQLiteDatabase db;
   private MyDatabaseHelper openHelper;
    private Cursor mCursor;
    //数据改变后指定通知的Uri
    private static final Uri NOTIFY_URI = Uri.parse("content://" + AUTHORITY + "/student");
    //在静态代码块中添加要匹配的 Uri
    static {
        mUriMatch=new UriMatcher(UriMatcher.NO_MATCH);
        /**
         * uriMatcher.addURI(authority, path, code); 其中
         * authority：主机名(用于唯一标示一个ContentProvider,这个需要和清单文件中的authorities属性相同)
         * path:路径路径(可以用来表示我们要操作的数据，路径的构建应根据业务而定)
         * code:返回值(用于匹配uri的时候，作为匹配成功的返回值)
         */
        mUriMatch.addURI(AUTHORITY,"student",MATCH_ALL_CODE);// 匹配记录集合
        mUriMatch.addURI(AUTHORITY,"student/#",MATCH_ONE_CODE);// 匹配单条记录
    }

    @Override
    public boolean onCreate() {
        openHelper=new MyDatabaseHelper(getContext(),"person.db",null,1);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
