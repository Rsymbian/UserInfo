package com.app.rabia.myapplication.view.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.rabia.myapplication.R;
import com.app.rabia.myapplication.domain.UserDataModel;


public class MainScreenFragment extends Fragment implements ItemClickedHandler {


    private RecyclerView recyclerView;
    private UserDataModel mData;
    private MainScreenAdapter mAdapter;
    private ItemClickedHandler mUserActionListener;


    public MainScreenFragment(UserDataModel dataModel, ItemClickedHandler actionHandler) {
        mData = dataModel;
        mUserActionListener = actionHandler;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.title_list, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.title_list);
        mAdapter = new MainScreenAdapter(mData.getUserData(), this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                UserInfoFragment detailFragment = new  UserInfoFragment(new UserAllInfo("rabia", "text body", "rr", 2));
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.title_screen, detailFragment);
//                //ft.addToBackStack("second screen");
//                ft.commit();
//            }
//
//                @Override
//                public void onItemLongClick (View view,int position){
//
//                }
//            }

        //          ));
        recyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onItemClicked(int id) {
        mUserActionListener.onItemClicked(id);
    }
}
