package com.app.rabia.myapplication.datasource;

import com.app.rabia.myapplication.domain.UserDataModel;

public interface DataReady {

    void onDataReady(UserDataModel mData);

    void OnError();
}
