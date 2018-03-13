package com.example.jdsm.sqlitedemo.ContentProviderGetContacts;

/**
 * Created by Well Wang on 2018/3/13.
 */

public class ContactsInfo {

    String name;
    String phonenumber;

    public  ContactsInfo(String name, String phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
