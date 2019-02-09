package com.beloushkin.learning.android.heterogenousrecyclerview.mock;

import java.util.ArrayList;
import java.util.List;

public class MockData {

    private ArrayList<Object> mList = new ArrayList<>();

    List<Object> mockList() {
        return  mList;
    }

    //Singleton methods
    private static MockData mInstance;

    public static void initInstance() {
        if (mInstance == null) {
            mInstance = new MockData();
        }
    }

    public static MockData getInstance() {
        return mInstance;
    }

}
