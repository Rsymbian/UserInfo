package com.app.rabia.myapplication.view.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.app.rabia.myapplication.R;
import com.app.rabia.myapplication.domain.UserDataModel;
import com.app.rabia.myapplication.view.details.DetailPresenter;

public class MainActivity extends AppCompatActivity implements ItemClickedHandler {

    private static StartupPresenter presenter;
    private DetailPresenter detailPresenter;
    private UserDataModel mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (presenter == null) {
            presenter = new StartupPresenter();
        }
        presenter.onTakeView(this);

    }

    public void startCallCompleted(UserDataModel dataModel) {
        mData = dataModel;
        Fragment newFragment = new MainScreenFragment(dataModel, this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack("First Screen");
        ft.add(R.id.title_screen, newFragment).commit();
    }

    @Override
    public void onItemClicked(int id) {
        detailPresenter = new DetailPresenter(mData);
        detailPresenter.takeOnView(this);
        detailPresenter.showDetails(id);

    }

    public void errorOnStartUp() {
        Toast.makeText(this, "error loading data", Toast.LENGTH_SHORT).show();
    }
}
