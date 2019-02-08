package com.beloushkin.learning.android.heterogenousrecyclerview.mock;

public class MockPictureInfo {
    private String mName;
    private String mPictureUrl;

    public MockPictureInfo(String name, String pictureUrl) {
        mName = name;
        mPictureUrl = pictureUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPictureUrl() {
        return mPictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        mPictureUrl = pictureUrl;
    }
}
