package com.beloushkin.learning.android.heterogenousrecyclerview.mock;

public class MockPictureInfo {

    private String mLabel;
    private String mPictureUrl;
    private int mId;

    public MockPictureInfo(String label, String pictureUrl) {
        mLabel = label;
        mPictureUrl = pictureUrl;
    }

    public String getLabel() {
        return mLabel;
    }

    public void setLabel(String label) {
        mLabel = label;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getPictureUrl() {
        return mPictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        mPictureUrl = pictureUrl;
    }
}
