package com.beloushkin.learning.android.heterogenousrecyclerview;

import android.app.Application;

import com.beloushkin.learning.android.heterogenousrecyclerview.mock.MockData;
import com.beloushkin.learning.android.heterogenousrecyclerview.mock.MockGenerator;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MockData.initInstance();

        MockData mMockData = MockData.getInstance();
        MockGenerator mockGenerator = new MockGenerator(getApplicationContext());
        mMockData.addItem(mockGenerator.generateTextInfo());
        mMockData.addItem(mockGenerator.generatePictureInfo());
    }
}
