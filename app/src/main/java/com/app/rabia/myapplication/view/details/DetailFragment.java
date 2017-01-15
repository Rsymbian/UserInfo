package com.app.rabia.myapplication.view.details;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.rabia.myapplication.R;
import com.app.rabia.myapplication.datasource.DataInfo;

import static com.app.rabia.myapplication.R.layout.userinfo;

public class DetailFragment extends Fragment {

    private DataInfo mUserInfo;

    public DetailFragment() {

    }

    public void setData(DataInfo userinfo) {
        mUserInfo = userinfo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(userinfo, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView title = (TextView) getActivity().findViewById(R.id.title_txt);
        TextView body = (TextView) getActivity().findViewById(R.id.body_txt);
        TextView username = (TextView) getActivity().findViewById(R.id.username_txt);
        TextView total_comments = (TextView) getActivity().findViewById(R.id.total_comments_txt);
        if (mUserInfo != null) {
            title.setText(getFormattedString("Post Title :", mUserInfo.getTitle()));
            body.setText(getFormattedString("Description :", mUserInfo.getBody()));
            username.setText(getFormattedString("Username :", mUserInfo.getName()));
            total_comments.setText(getFormattedString("Total Comments :", mUserInfo.getTotalCommentsCount() + ""));
        }
    }

    private SpannableString getFormattedString(String part1, String part2) {
        SpannableString str = new SpannableString(part1 + part2);
        str.setSpan(new StyleSpan(Typeface.BOLD), 0, part1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return str;
    }
}
