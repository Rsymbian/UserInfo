package com.app.rabia.myapplication.main;

import android.app.Application;
import android.content.Context;

import com.app.rabia.myapplication.utils.PicassoModule;
import com.squareup.picasso.Picasso;


public class MyApplication extends Application {

    private static MyApplication sApplicationInstance;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static MyApplication getInstance() {
        if (null == sApplicationInstance) {
            sApplicationInstance = new MyApplication();
        }
        return sApplicationInstance;
    }

    protected static void setInstance(MyApplication application) {
        sApplicationInstance = application;
    }

    public Picasso getPicasso(Context context) {
        return PicassoModule.getInstance(context);//PicassoModule.getInstance(getApplicationContext());
    }
}
