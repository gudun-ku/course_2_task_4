package com.beloushkin.learning.android.heterogenousrecyclerview.mock;

public class MockTextInfo {

    private String mName;
    private String mDescription;
    private int mValue;


    public MockTextInfo(String name, String description, int value) {
        mName = name;
        mDescription = description;
        mValue = value;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getValue() {
        return String.valueOf(mValue);
    }

    public void setValue(int value) {
        mValue = value;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
