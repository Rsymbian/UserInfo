package com.app.rabia.myapplication.utils;

import android.content.Context;

import com.squareup.picasso.Picasso;

// Picasso Module to load images

public class PicassoModule {

    private static Picasso sInstance;

    public static Picasso getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new Picasso.Builder(context).build();
        }
        return sInstance;
    }

}
