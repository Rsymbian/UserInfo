package com.app.rabia.myapplication.di;

import android.content.Context;

import com.app.rabia.myapplication.datasource.server.ServerClient;
import com.app.rabia.myapplication.datasource.server.StartupCallProvider;
import com.app.rabia.myapplication.utils.PicassoModule;
import com.app.rabia.myapplication.view.titles.StartupPresenter;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by mansoor on 19/01/2017.
 */
@Module

public class ApplicationModule {

    private Context context;
    private Retrofit mRetrofit;

    public ApplicationModule(Context context) {
        this.context = context;

    }

    @Provides
    @Singleton
    public Picasso providePicasso() {
        return PicassoModule.getInstance(context);
    }

    @Provides
    @Singleton
    public StartupPresenter provideStartupPresenter() {
        mRetrofit = ServerClient.getClient();
        return new StartupPresenter(new StartupCallProvider(mRetrofit));
    }

}
