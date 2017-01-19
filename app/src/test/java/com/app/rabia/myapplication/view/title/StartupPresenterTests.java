package com.app.rabia.myapplication.view.title;

import com.app.rabia.myapplication.datasource.DataReady;
import com.app.rabia.myapplication.datasource.server.StartupCallProvider;
import com.app.rabia.myapplication.domain.UserDataModel;
import com.app.rabia.myapplication.view.titles.MainView;
import com.app.rabia.myapplication.view.titles.StartupPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class StartupPresenterTests {

    private StartupPresenter mClassUnderTest;


    private MainView mView;

    @Mock
    private UserDataModel mData;

    @Mock
    private StartupCallProvider mProvider;

    @Mock
    private DataReady mockDataReady;

    @Before
    public void setup() {

    }

    @Test
    public void testStartCompleteCallInvokedWhenDataIsReady() {
//        mClassUnderTest = new StartupPresenter(mProvider);
//        mClassUnderTest.onTakeView(mView);
//        mClassUnderTest.onDataReady(mData);
//        verify(mView, times(1)).startCallCompleted(mData);
    }
}
