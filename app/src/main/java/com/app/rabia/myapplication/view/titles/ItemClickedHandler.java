package com.app.rabia.myapplication.view.titles;

import com.app.rabia.myapplication.domain.UserDataModel;


public interface ItemClickedHandler {

    void onItemClicked(int id);

    void setData(UserDataModel data);
}
