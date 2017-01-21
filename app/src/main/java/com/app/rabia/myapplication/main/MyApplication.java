package com.app.rabia.myapplication.main;

import android.app.Application;
import android.content.Context;

import com.app.rabia.myapplication.di.ApplicationComponent;
import com.app.rabia.myapplication.di.ApplicationModule;
import com.app.rabia.myapplication.di.DaggerApplicationComponent;
import com.app.rabia.myapplication.utils.Constants;


public class MyApplication extends Application {

    private static MyApplication sApplicationInstance;
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

    public ApplicationComponent getApplicationComponent(Context context) {
        return DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(context)).build();
    }

    public void setCacheDirectory(Context context) {
        mCache = new okhttp3.Cache(context.getCacheDir(), Constants.CACHE_SIZE);
    }

    public okhttp3.Cache getCacheDirectory() {
        return mCache;
    }
}
