package com.app.rabia.myapplication.view.details;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.rabia.myapplication.R;
import com.app.rabia.myapplication.datasource.DataInfo;

public class DetailFragment extends Fragment {

    private DataInfo mUserInfo;

    public DetailFragment(DataInfo userinfo) {
        mUserInfo = userinfo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.userinfo, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView title = (TextView) getActivity().findViewById(R.id.title_txt);
        TextView body = (TextView) getActivity().findViewById(R.id.body_txt);
        TextView username = (TextView) getActivity().findViewById(R.id.username_txt);
        TextView total_comments = (TextView) getActivity().findViewById(R.id.total_comments_txt);
        if (mUserInfo != null) {
            title.setText(mUserInfo.getTitle());
            body.setText(mUserInfo.getBody());
            username.setText(mUserInfo.getName());
            total_comments.setText(mUserInfo.getTotalCommentsCount() + "");
        }
    }

}
