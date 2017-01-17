package com.app.rabia.myapplication.utils;

import android.content.Context;

import com.squareup.picasso.Picasso;

/**
 * Created by mansoor on 16/01/2017.
 */

public class PicassoModule {

    private static Picasso instance;

    public static Picasso getInstance(Context context) {
        if (instance == null) {
            instance = new Picasso.Builder(context).build();
        }
        return instance;
    }

}