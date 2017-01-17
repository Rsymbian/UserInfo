package com.app.rabia.myapplication.main;

import android.app.Application;

import com.squareup.picasso.Picasso;

/**
 * Created by mansoor on 16/01/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public Picasso getPicasso() {
        return new Picasso.Builder(getApplicationContext()).build();//PicassoModule.getInstance(getApplicationContext());
    }
}
