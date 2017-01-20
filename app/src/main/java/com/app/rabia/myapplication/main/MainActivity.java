package com.app.rabia.myapplication.main;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.app.rabia.myapplication.R;
import com.app.rabia.myapplication.domain.UserDataModel;
import com.app.rabia.myapplication.view.details.DetailFragment;
import com.app.rabia.myapplication.view.titles.ItemClickedHandler;
import com.app.rabia.myapplication.view.titles.MainScreenFragment;

public class MainActivity extends AppCompatActivity implements ItemClickedHandler {

    private UserDataModel mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getInstance().setCacheDirectory(this);
        setContentView(R.layout.activity_main);
        MainScreenFragment fragment = new MainScreenFragment();
        fragment.setData(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.title_screen, fragment, fragment.getClass().getSimpleName()).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    public void onItemClicked(int id) {
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setData(mData.getUserAllInfo(id));
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.title_screen, detailFragment).addToBackStack("main sceen");
        ft.commit();
    }

    @Override
    public void setData(UserDataModel data) {
        mData = data;
    }
}
