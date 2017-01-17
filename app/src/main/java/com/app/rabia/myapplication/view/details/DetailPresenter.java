package com.app.rabia.myapplication.view.details;

import android.support.v4.app.FragmentTransaction;

import com.app.rabia.myapplication.main.MainActivity;
import com.app.rabia.myapplication.R;
import com.app.rabia.myapplication.domain.UserDataModel;


public class DetailPresenter {

    private MainActivity mActivity;
    private UserDataModel mDataModel;

    public DetailPresenter(UserDataModel userDataModel) {
        mDataModel = userDataModel;
    }

    public void takeOnView(MainActivity activity) {
        mActivity = activity;
    }

    public void showDetails(int id) {
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setData(mDataModel.getUserAllInfo(id));
        FragmentTransaction ft = mActivity.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.title_screen, detailFragment).addToBackStack("main sceen");
        ft.commit();
    }
}
