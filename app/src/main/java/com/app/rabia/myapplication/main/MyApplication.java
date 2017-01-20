package com.app.rabia.myapplication.main;

import android.app.Application;
import android.content.Context;

import com.app.rabia.myapplication.di.ApplicationComponent;
import com.app.rabia.myapplication.di.ApplicationModule;
import com.app.rabia.myapplication.di.DaggerApplicationComponent;


public class MyApplication extends Application {

    private static MyApplication sApplicationInstance;
    private static final long CACHE_SIZE = 1 * 1024 * 1024;
    private okhttp3.Cache mCache;


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

    public ApplicationComponent getApplicationComponent(Context context) {
        return DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(context)).build();
    }

    public void setCacheDirectory(Context context) {
        mCache = new okhttp3.Cache(context.getCacheDir(), CACHE_SIZE);
    }

    public okhttp3.Cache getCacheDirectory() {
        return mCache;
    }
}
