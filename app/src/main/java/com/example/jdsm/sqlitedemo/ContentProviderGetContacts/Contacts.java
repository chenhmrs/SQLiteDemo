package com.example.jdsm.sqlitedemo.ContentProviderGetContacts;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Well Wang on 2018/3/13.
 */

public class Contacts {

    Cursor cursor;

    public List<ContactsInfo> GetContacts(Context context) {
        List<ContactsInfo> datalistView = new ArrayList<>();
        try {
            //得到访问者
            ContentResolver cr = context.getContentResolver();
            //定义一个接收联系人姓名和电话号码的集合
            Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
            cursor = cr.query(uri, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(cursor.getColumnIndex("_id"));
                    Uri uriData = Uri.parse("content://com.android.contacts/raw_contacts/" + id + "/data");
                    Cursor contactData = cr.query(uriData, null, null, null, null);
                    //用来装姓名
                    String aa = "";
                    //用来装号码
                    String bb = "";
                    if (contactData != null) {
                        while (contactData.moveToNext()) {
                            String type = contactData.getString(contactData.getColumnIndex("mimetype"));
                            //如果获取的是vnd.android.cursor.item/phone_v2则是号码
                            if (type.equals("vnd.android.cursor.item/phone_v2")) {
                                String tempnum = contactData.getString(contactData.getColumnIndex("data1"));
                                bb = tempnum.replaceAll(" ", "");
                                //如果获取的是vnd.android.cursor.item/name则是姓名
                            } else if (type.equals("vnd.android.cursor.item/name")) {
                                aa = contactData.getString(contactData.getColumnIndex("data1"));
                            }
                        }
                    }
                    ContactsInfo contacts = new ContactsInfo(aa, bb);
                    datalistView.add(contacts);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return datalistView;
    }
}