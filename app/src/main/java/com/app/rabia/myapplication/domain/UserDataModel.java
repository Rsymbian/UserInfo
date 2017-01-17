package com.app.rabia.myapplication.domain;

import com.app.rabia.myapplication.datasource.UserInfo;
import com.app.rabia.myapplication.datasource.data.CommentData;
import com.app.rabia.myapplication.datasource.data.PostData;
import com.app.rabia.myapplication.datasource.data.UserData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDataModel {

    private List<UserData> userData;
    private List<PostData> postData;
    private List<CommentData> commentData;
    private Map<Integer, UserInfo> mData = new HashMap<Integer, UserInfo>();

    public UserDataModel(List<UserData> userDatas, List<PostData> postDatas, List<CommentData> commentDatas) {
        this.userData = userDatas;
        this.postData = postDatas;
        this.commentData = commentDatas;
        prepareAllInfoUser();
    }


    private void prepareAllInfoUser() {
        for (int i = 0; i < postData.size(); i++) {
            mData.put(postData.get(i).getId(), getUserAllInfo(postData.get(i).getId()));
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
        for (int i = 0; i < commentData.size(); i++) {
            if (commentData.get(i).getPostId() == id) {
                commentsCount++;
            }
        }

        return commentsCount;
    }

    private String getBodyById(int id) {

        int postId = getUserIdbyPostId(id);
        for (int i = 0; i < postData.size(); i++) {
            if (postData.get(i).getId() == postId) {
                return postData.get(i).getBody();
            }
        }
        return null;
    }

    private int getUserIdbyPostId(int id) {
        for (int i = 0; i < postData.size(); i++) {
            if (postData.get(i).getId() == id) {
                return postData.get(i).getUserId();
            }
        }
        return -1;
    }


    private String getNameById(int id) {
        for (int i = 0; i < userData.size(); i++) {
            if (userData.get(i).getId() == id) {
                return userData.get(i).getName();
            }
        }
        return null;
    }

    private String getTitleById(int id) {
        for (int i = 0; i < postData.size(); i++) {
            if (postData.get(i).getId() == id) {
                return postData.get(i).getTitle();
            }
        }
        return null;
    }

    private String getEmailbyId(int id) {
        String email = null;
        for (int i = 0; i < userData.size(); i++) {
            if (userData.get(i).getId() == id) {
                email = userData.get(i).getEmail();
            }
        }

        return email;
    }

}
