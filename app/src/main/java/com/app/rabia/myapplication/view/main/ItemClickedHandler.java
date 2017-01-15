package com.app.rabia.myapplication.view.main;

import com.app.rabia.myapplication.domain.UserDataModel;

/**
 * Created by mansoor on 18/12/2016.
 */

public interface ItemClickedHandler {

    void onItemClicked(int id);

    void setData(UserDataModel data);
}
