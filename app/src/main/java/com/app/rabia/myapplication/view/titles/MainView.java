package com.app.rabia.myapplication.view.titles;

import com.app.rabia.myapplication.domain.UserDataModel;

public interface MainView {

    void startCallCompleted(UserDataModel userDataModel);

    void errorOnStartUp();
}
