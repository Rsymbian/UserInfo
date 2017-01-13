package com.app.rabia.myapplication.datasource;

import com.app.rabia.myapplication.domain.UserDataModel;

/**
 * Created by mansoor on 12/12/2016.
 */

public interface DataReady {

    void onDataReady(UserDataModel mData);

    void OnError();
}
