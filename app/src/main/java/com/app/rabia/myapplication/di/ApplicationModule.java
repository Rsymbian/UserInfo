package com.app.rabia.myapplication.di;

import android.content.Context;

import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mansoor on 19/01/2017.
 */
@Module

public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {

        this.context = context;
    }

    @Provides
    @Singleton
    public Picasso providePicasso() {
        return new Picasso.Builder(context).build();
    }
}
