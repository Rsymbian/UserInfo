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

public class StartupCallProvider {

    private DataReady mDataReady;
    private UserDataModel mData;
    private Retrofit mRetrofit;

    public StartupCallProvider(Retrofit client) {
        mRetrofit = client;
    }


    public void loadStartupData(DataReady dataReady) {

        mDataReady = dataReady;
        Observable<List<UserData>> userDataObservable = ClientProvider.getUserDataClient(mRetrofit);
        Observable<List<PostData>> postDataObservable = ClientProvider.getPostDataClient(mRetrofit);
        Observable<List<CommentData>> commentDataObservable = ClientProvider.getCommentDataClient(mRetrofit);

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