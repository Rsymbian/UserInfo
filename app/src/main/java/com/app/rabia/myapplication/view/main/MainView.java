package com.app.rabia.myapplication.view.main;

import com.app.rabia.myapplication.domain.UserDataModel;

/**
 * Created by mansoor on 14/01/2017.
 */

public interface MainView {

    void startCallCompleted(UserDataModel userDataModel);

    void errorOnStartUp();
}
