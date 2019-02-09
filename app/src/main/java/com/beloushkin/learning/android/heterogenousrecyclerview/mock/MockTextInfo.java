package com.beloushkin.learning.android.heterogenousrecyclerview.mock;

public class MockTextInfo {

    private String mName;
    private String mDescription;
    private int mId;


    public MockTextInfo(String name, String description, int id) {
        mName = name;
        mDescription = description;
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getValue() {
        return String.valueOf(mId);
    }

    public void setId(int id) {
        mId = id;
    }

    public int getId() {
        return mId;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
