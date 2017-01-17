package com.app.rabia.myapplication.view.titles;

import com.app.rabia.myapplication.datasource.DataReady;
import com.app.rabia.myapplication.datasource.server.ServerClient;
import com.app.rabia.myapplication.datasource.server.StartupCallProvider;
import com.app.rabia.myapplication.domain.UserDataModel;


public class StartupPresenter implements DataReady {

    private MainView mView;

    public StartupPresenter() {
        new StartupCallProvider().loadStartupData(this, ServerClient.getClient());
    }

    public void onTakeView(MainView view) {
        this.mView = view;
    }


    @Override
    public void onDataReady(UserDataModel dataModel) {
        mView.startCallCompleted(dataModel);
    }

    @Override
    public void OnError() {
        mView.errorOnStartUp();
    }
}
