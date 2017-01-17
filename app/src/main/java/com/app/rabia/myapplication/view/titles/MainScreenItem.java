package com.app.rabia.myapplication.view.titles;

public class MainScreenItem {

    private int id;
    private String title;
    private String email;


    public MainScreenItem( int id, String title, String email ) {
        this.id = id;
        this.title = title;
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }

}
