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
import android.widget.ImageView;
import android.widget.TextView;

import com.app.rabia.myapplication.R;
import com.app.rabia.myapplication.datasource.UserInfo;
import com.app.rabia.myapplication.main.MyApplication;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class DetailFragment extends Fragment {

    private UserInfo mUserInfo;
    private static final String IMAGE_BASE_URL = "https://api.adorable.io/avatars/285/";

    @Inject
    Picasso picasso;

    public DetailFragment() {

    }

    public void setData(UserInfo userinfo) {
        mUserInfo = userinfo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        MyApplication.getInstance().getApplicationComponent(getActivity()).inject(this);
        return inflater.inflate(R.layout.userinfo, parent, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView title = (TextView) getActivity().findViewById(R.id.title_txt);
        TextView body = (TextView) getActivity().findViewById(R.id.body_txt);
        TextView username = (TextView) getActivity().findViewById(R.id.username_txt);
        TextView total_comments = (TextView) getActivity().findViewById(R.id.total_comments_txt);
        ImageView image = (ImageView) getActivity().findViewById(R.id.detial_image);
        if (mUserInfo != null) {
            username.setText(mUserInfo.getName());
            title.setText(getFormattedString(getActivity().getResources().getString(R.string.post_title), mUserInfo.getTitle()));
            body.setText(getFormattedString(getActivity().getResources().getString(R.string.description), mUserInfo.getBody()));
            total_comments.setText(getFormattedString(getActivity().getResources().getString(R.string.description), mUserInfo.getTotalCommentsCount() + ""));
            picasso.load(IMAGE_BASE_URL + mUserInfo.getEmailAddress() + ".png").placeholder(R.drawable.image_placeholder).into(image);
        }
    }

    private SpannableString getFormattedString(String part1, String part2) {
        SpannableString str = new SpannableString(part1 + part2);
        str.setSpan(new StyleSpan(Typeface.BOLD), 0, part1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return str;
    }
}
