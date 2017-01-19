package com.app.rabia.myapplication.main;

import android.app.Application;
import android.content.Context;

import com.app.rabia.myapplication.di.ApplicationComponent;
import com.app.rabia.myapplication.di.ApplicationModule;
import com.app.rabia.myapplication.di.DaggerApplicationComponent;


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

    public ApplicationComponent getApplicationComponent(Context context) {
       return DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(context)).build();
    }

}
