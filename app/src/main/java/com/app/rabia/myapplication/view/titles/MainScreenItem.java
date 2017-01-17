package com.app.rabia.myapplication.view.titles;

public class MainScreenItem {

    private int mId;
    private String mTitle;
    private String mEmail;


    public MainScreenItem( int id, String title, String email ) {
        mId = id;
        mTitle = title;
        mEmail = email;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getId() {
        return mId;
    }


    public String getEmail() {
        return mEmail;
    }

}
