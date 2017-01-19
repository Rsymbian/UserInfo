package com.app.rabia.myapplication.di;

import android.content.Context;

import com.app.rabia.myapplication.datasource.server.ServerClient;
import com.app.rabia.myapplication.datasource.server.StartupCallProvider;
import com.app.rabia.myapplication.view.titles.StartupPresenter;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

/**
 * Created by mansoor on 19/01/2017.
 */
@Module

public class ApplicationModule {

    private Context context;
    private Retrofit mRetrofit;

    public ApplicationModule(Context context) {
        this.context = context;
        mRetrofit = ServerClient.getClient();
    }

    @Provides
    @Singleton
    public Picasso providePicasso() {
        return new Picasso.Builder(context).build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return ServerClient.getClient();
    }

    @Provides
    @Singleton
    public StartupCallProvider provideStartupCallProvider(Retrofit retrofit) {
        return new StartupCallProvider(retrofit);
    }

    @Provides
    @Singleton
    public StartupPresenter provideStartupPresenter() {
        return new StartupPresenter(new StartupCallProvider(mRetrofit));
    }

}
