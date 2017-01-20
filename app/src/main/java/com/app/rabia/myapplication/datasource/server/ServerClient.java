package com.app.rabia.myapplication.datasource.server;

import com.app.rabia.myapplication.main.MyApplication;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.app.rabia.myapplication.utils.Constants.BASE_URL;

public class ServerClient {

    private static final long CACHE_SIZE = 1 * 1024 * 1024;


    public static Retrofit getClient() {
        Retrofit retrofit = null;
        //Context context = MyApplication.getInstance();
        //Cache ca = new Cache(MyApplication.getInstance().getBaseContext().getCacheDir(),CACHE_SIZE);

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder().cache(MyApplication.getInstance().getCacheDirectory());
        OkHttpClient okHttpClient= okHttpClientBuilder.build();


        if (retrofit == null) retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}
