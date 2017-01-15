package com.app.rabia.myapplication.view.main;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.app.rabia.myapplication.R;
import com.app.rabia.myapplication.domain.UserDataModel;
import com.app.rabia.myapplication.view.details.DetailFragment;

public class MainActivity extends AppCompatActivity implements ItemClickedHandler {

    private UserDataModel mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        MainScreenFragment fragment = new MainScreenFragment();
        fragment.setData(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.title_screen, fragment, fragment.getClass().getSimpleName()).commit();
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
