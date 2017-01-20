package com.app.rabia.myapplication.datasource.server;

import com.app.rabia.myapplication.datasource.data.CommentData;
import com.app.rabia.myapplication.datasource.data.PostData;
import com.app.rabia.myapplication.datasource.data.UserData;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;



public interface ServerAPI {


    @GET("posts")
    Observable<List<PostData>> getPosts();

    @GET("users")
    Observable<List<UserData>> getUsers();

    @GET("comments")
    Observable<List<CommentData>> getComments();
}
