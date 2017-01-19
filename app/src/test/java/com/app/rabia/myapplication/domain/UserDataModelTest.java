package com.app.rabia.myapplication.domain;

import com.app.rabia.myapplication.datasource.data.AddressData;
import com.app.rabia.myapplication.datasource.data.CommentData;
import com.app.rabia.myapplication.datasource.data.CompanyData;
import com.app.rabia.myapplication.datasource.data.PostData;
import com.app.rabia.myapplication.datasource.data.UserData;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserDataModelTest {

    UserDataModel mClassUnderTest;

    private List<UserData> mUserTestData;
    private List<PostData> mPostTestData;
    private List<CommentData> mCommentTestData;

    @Before
    public void setup() {

        mUserTestData = new ArrayList<>();
        mUserTestData.add(new UserData(1, new CompanyData(), "", "", new AddressData(), "abc@abc.com", "title1", "username1"));
        mUserTestData.add(new UserData(2, new CompanyData(), "", "", new AddressData(), "123@123.com", "title2", "username2"));
        mUserTestData.add(new UserData(3, new CompanyData(), "", "", new AddressData(), "xyz@xyz.com", "title3", "username3"));

        mPostTestData = new ArrayList<>();
        mPostTestData.add(new PostData(1, 10, "title1", "body of title1"));
        mPostTestData.add(new PostData(2, 11, "title2", "body of title2"));
        mPostTestData.add(new PostData(3, 12, "title3", "body of title3"));

        mCommentTestData = new ArrayList<>();
        mCommentTestData.add(new CommentData(10, 20, "username1", "abc@abc.com", "comment 1"));
        mCommentTestData.add(new CommentData(10, 30, "username1", "abc@abc.com", "comment 2"));
        mCommentTestData.add(new CommentData(10, 40, "username1", "abc@abc.com", "comment 3"));
        mCommentTestData.add(new CommentData(11, 30, "username2", "123@123.com", "comment 1"));
        mCommentTestData.add(new CommentData(11, 40, "username2", "123@123", "comment 2"));
        mCommentTestData.add(new CommentData(12, 30, "username2", "xyz@xyz.com", "comment 1"));

        mClassUnderTest = new UserDataModel(mUserTestData, mPostTestData, mCommentTestData);
    }

    @Test
    public void testDataisLoadedInModel() {
        Assert.assertNotNull(mClassUnderTest.getAllUserInfo());
    }

    @Test
    public void tesEmailIsRetrievingCorrectlyWithValidId() {
        Assert.assertEquals("abc@abc.com", mClassUnderTest.getUserAllInfo(10).getEmailAddress());
        Assert.assertEquals("123@123.com", mClassUnderTest.getUserAllInfo(11).getEmailAddress());
        Assert.assertEquals("xyz@xyz.com", mClassUnderTest.getUserAllInfo(12).getEmailAddress());
    }

    @Test
    public void tesEmailIsRetrievingCorrectlyWithInvalidId() {
        Assert.assertEquals(null, mClassUnderTest.getUserAllInfo(40).getEmailAddress());
    }

    @Test
    public void testUsernameIsRetrievedCorrectlyWithValidId() {
        Assert.assertEquals("username1", mClassUnderTest.getUserAllInfo(10).getName());
        Assert.assertEquals("username2", mClassUnderTest.getUserAllInfo(11).getName());
        Assert.assertEquals("username3", mClassUnderTest.getUserAllInfo(12).getName());
    }

    @Test
    public void testUsernameIsRetrievedCorrectlyWithInvalidId() {
        Assert.assertEquals(null, mClassUnderTest.getUserAllInfo(40).getName());
    }

    @Test
    public void testCommentCountIsRetrievedCorrectlyWithValidId() {
        Assert.assertEquals(3, mClassUnderTest.getUserAllInfo(10).getTotalCommentsCount());
        Assert.assertEquals(2, mClassUnderTest.getUserAllInfo(11).getTotalCommentsCount());
        Assert.assertEquals(1, mClassUnderTest.getUserAllInfo(12).getTotalCommentsCount());
    }

    @Test
    public void testCommentCounteIsRetrievedCorrectlyWithInvalidId() {
        Assert.assertEquals(0, mClassUnderTest.getUserAllInfo(40).getTotalCommentsCount());
    }
}
