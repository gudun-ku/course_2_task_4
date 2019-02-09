package com.beloushkin.learning.android.heterogenousrecyclerview;

import android.app.Application;

import com.beloushkin.learning.android.heterogenousrecyclerview.mock.MockData;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MockData.initInstance();
    }
}
