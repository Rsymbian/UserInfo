package com.app.rabia.myapplication.view.main;

/**
 * Created by mansoor on 14/01/2017.
 */

public class MainScreenItem {

    private int id;
    private String title;


    public MainScreenItem( int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}
