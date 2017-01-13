package com.app.rabia.myapplication.datasource.server;

import com.app.rabia.myapplication.datasource.data.CommentData;
import com.app.rabia.myapplication.datasource.data.PostData;
import com.app.rabia.myapplication.domain.UserDataModel;
import com.app.rabia.myapplication.datasource.data.UserData;
import com.app.rabia.myapplication.datasource.DataReady;

import java.util.List;

import retrofit.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func3;

/**
 * Created by mansoor on 10/12/2016.
 */

public class StartupCallProvider {

    private DataReady mDataReady;
    private UserDataModel mData;


    public void loadStartupData(DataReady dataReady, Retrofit client) {

        mDataReady = dataReady;
        Observable<List<UserData>> userDataObservable = ClientProvider.getUserDataClient(client);
        Observable<List<PostData>> postDataObservable = ClientProvider.getPostDataClient(client);
        Observable<List<CommentData>> commentDataObservable = ClientProvider.getCommentDataClient(client);

        Observable<UserDataModel> combined = Observable.zip(userDataObservable, postDataObservable, commentDataObservable, new Func3<List<UserData>, List<PostData>, List<CommentData>, UserDataModel>() {
            @Override
            public UserDataModel call(List<UserData> userDatas, List<PostData> postDatas, List<CommentData> commentDatas) {
                mData = new UserDataModel(userDatas, postDatas, commentDatas);
                return mData;
            }

        });

        combined.subscribe(new Subscriber<UserDataModel>() {
            @Override
            public void onCompleted() {
                mDataReady.onDataReady(mData);

            }

            @Override
            public void onError(Throwable e) {
                mDataReady.OnError();
            }

            @Override
            public void onNext(UserDataModel postAndUserData) {
            }
        });
    }

    public UserDataModel getData() {
        return mData;
    }


}