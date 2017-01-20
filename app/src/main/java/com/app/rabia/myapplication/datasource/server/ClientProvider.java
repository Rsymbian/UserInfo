package com.app.rabia.myapplication.datasource.server;

import com.app.rabia.myapplication.datasource.data.CommentData;
import com.app.rabia.myapplication.datasource.data.PostData;
import com.app.rabia.myapplication.datasource.data.UserData;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ClientProvider {

    public static Observable<List<UserData>> getUserDataClient(Retrofit client) {

        return client.
                create(ServerAPI.class)
                .getUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<List<PostData>> getPostDataClient(Retrofit client) {
        return (client.
                create(ServerAPI.class)
                .getPosts()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()));
    }

    public static Observable<List<CommentData>> getCommentDataClient(Retrofit client) {
        return (client.
                create(ServerAPI.class)
                .getComments()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()));

    }
}
