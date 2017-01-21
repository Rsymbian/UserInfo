package com.app.rabia.myapplication.view.titles;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.app.rabia.myapplication.R;
import com.app.rabia.myapplication.domain.UserDataModel;
import com.app.rabia.myapplication.main.MyApplication;

import javax.inject.Inject;


public class MainScreenFragment extends Fragment implements NotifyListItemClicked, MainView {
    private RecyclerView mRecyclerView;
    private UserDataModel mData;
    private MainScreenAdapter mAdapter;
    private ItemClickedHandler mUserActionListener;
    private static StartupPresenter presenter;
    private View mRootView;

    @Inject
    StartupPresenter startupPresenter;
    private TextView mEmptyText;

    public MainScreenFragment() {
        //data loads on every start up
        MyApplication.getInstance().getApplicationComponent(getActivity()).inject(this);
        startupPresenter.startLoading();
        startupPresenter.onTakeView(this);
    }

    public void setData(ItemClickedHandler actionHandler) {
        mUserActionListener = actionHandler;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.title_list, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mRootView = view;
        if (mData != null) {
            populateData();
        } else {
            showEmptyView();
        }
    }

    private void showEmptyView() {
        mEmptyText = (TextView) getActivity().findViewById(R.id.empty_view);
        mEmptyText.setVisibility(View.VISIBLE);

    }

    @Override
    public void startCallCompleted(UserDataModel userDataModel) {
        mUserActionListener.setData(userDataModel);
        mData = userDataModel;
        populateData();

    }

    private void populateData() {
        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.titlelist);
        mEmptyText.setVisibility(View.GONE);
        mAdapter = new MainScreenAdapter(mData, this, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mRootView.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(ContextCompat.getDrawable(mRootView.getContext(), R.drawable.divider));
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void errorOnStartUp() {
        Toast.makeText(getActivity(), R.string.error_laoding, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void notifyListItemClicked(int id) {
        mUserActionListener.onItemClicked(id);
    }
}
