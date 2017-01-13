package com.app.rabia.myapplication.domain;

import com.app.rabia.myapplication.datasource.data.CommentData;
import com.app.rabia.myapplication.datasource.data.PostData;
import com.app.rabia.myapplication.datasource.DataInfo;
import com.app.rabia.myapplication.datasource.data.UserData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserDataModel {

    private List<UserData> userData;
    private List<PostData> postData;
    private List<CommentData> commentData;
    private Map<Integer, DataInfo> mData = new HashMap<Integer, DataInfo>();
    private Map<Integer, String> mTitleList = new HashMap<Integer, String>();

    public UserDataModel(List<UserData> userDatas, List<PostData> postDatas, List<CommentData> commentDatas) {
        this.userData = userDatas;
        this.postData = postDatas;
        this.commentData = commentDatas;
        createUserData();
        prepareAllInfoUser();
    }

    private void createUserData() {
        for (int i = 0; i < postData.size(); i++) {
            Integer key = postData.get(i).getId();
            String value = postData.get(i).getTitle();
            mTitleList.put(key, value);
        }
    }

    private void prepareAllInfoUser() {
        for (int i = 0; i < postData.size(); i++) {
            mData.put(postData.get(i).getId(), getUserAllInfo(postData.get(i).getId()));
        }
    }

    private Map<Integer, DataInfo> getAllUserInfo() {
        return mData;
    }

    public Map<Integer, String> getUserData() {
        return mTitleList;
    }

    public DataInfo getUserAllInfo(int id) {

        DataInfo userDataInfo = new DataInfo();
        userDataInfo.setId(id);
        userDataInfo.setTitle(mTitleList.get(id));
        userDataInfo.setName(getNameById(id));
        userDataInfo.setBody(getBodyById(id));
        userDataInfo.setTotalCommentsCount(getTotalCommentsById(id));
        return null;

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

        int postId = getPostIdbyId(id);
        for (int i = 0; i < postData.size(); i++) {
            if (postData.get(i).getId() == postId) {
                return postData.get(i).getBody();
            }
        }
        return null;
    }

    private int getPostIdbyId(int id) {
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

}
