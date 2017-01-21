package com.app.rabia.myapplication.domain;

import com.app.rabia.myapplication.datasource.UserInfo;
import com.app.rabia.myapplication.datasource.data.CommentData;
import com.app.rabia.myapplication.datasource.data.PostData;
import com.app.rabia.myapplication.datasource.data.UserData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Data Model to hold all data needed by App UI

public class UserDataModel {

    private List<UserData> mUserData;
    private List<PostData> mPostData;
    private List<CommentData> mCommentData;
    private Map<Integer, UserInfo> mData = new HashMap<Integer, UserInfo>();

    public UserDataModel(List<UserData> userDatas, List<PostData> postDatas, List<CommentData> commentDatas) {
        this.mUserData = userDatas;
        this.mPostData = postDatas;
        this.mCommentData = commentDatas;
        prepareAllInfoUser();
    }


    private void prepareAllInfoUser() {
        for (int i = 0; i < mPostData.size(); i++) {
            mData.put(mPostData.get(i).getId(), getUserAllInfo(mPostData.get(i).getId()));
        }
    }

    public Map<Integer, UserInfo> getAllUserInfo() {
        return mData;
    }

    public UserInfo getUserAllInfo(int id) {

        UserInfo userUserInfo = new UserInfo();
        userUserInfo.setId(id);
        userUserInfo.setTitle(getTitleById(id));
        userUserInfo.setName(getNameById(getUserIdbyPostId(id)));
        userUserInfo.setBody(getBodyById(id));
        userUserInfo.setTotalCommentsCount(getTotalCommentsById(id));
        userUserInfo.setEmailAddress(getEmailbyId(getUserIdbyPostId(id)));
        return userUserInfo;

    }

    private int getTotalCommentsById(int id) {
        int commentsCount = 0;
        for (int i = 0; i < mCommentData.size(); i++) {
            if (mCommentData.get(i).getPostId() == id) {
                commentsCount++;
            }
        }

        return commentsCount;
    }

    private String getBodyById(int id) {

        int postId = getUserIdbyPostId(id);
        for (int i = 0; i < mPostData.size(); i++) {
            if (mPostData.get(i).getId() == postId) {
                return mPostData.get(i).getBody();
            }
        }
        return null;
    }

    private int getUserIdbyPostId(int id) {
        for (int i = 0; i < mPostData.size(); i++) {
            if (mPostData.get(i).getId() == id) {
                return mPostData.get(i).getUserId();
            }
        }
        return -1;
    }


    private String getNameById(int id) {
        for (int i = 0; i < mUserData.size(); i++) {
            if (mUserData.get(i).getId() == id) {
                return mUserData.get(i).getName();
            }
        }
        return null;
    }

    private String getTitleById(int id) {
        for (int i = 0; i < mPostData.size(); i++) {
            if (mPostData.get(i).getId() == id) {
                return mPostData.get(i).getTitle();
            }
        }
        return null;
    }

    private String getEmailbyId(int id) {
        String email = null;
        for (int i = 0; i < mUserData.size(); i++) {
            if (mUserData.get(i).getId() == id) {
                email = mUserData.get(i).getEmail();
            }
        }

        return email;
    }

}
