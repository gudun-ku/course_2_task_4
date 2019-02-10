package com.beloushkin.learning.android.heterogenousrecyclerview.mock;

import java.util.ArrayList;
import java.util.List;

public class MockData  {

    private ArrayList<Object> mList = new ArrayList<>();

    public List<Object> mockList() {
        return  mList;
    }

    public interface MockDataListener {
        void itemAdded(int position);
        void itemRemoved(int position);
    }

    private MockDataListener mMockDataListener;

    public void setMockDataListener(MockDataListener listener){
        mMockDataListener = listener;
    }

    public void addData(List<Object> items) {
        mList.addAll(items);
    }

    public void addItem(Object item) {
        int position = mList.size();
        mList.add(item);
        if (mMockDataListener != null) {
            mMockDataListener.itemAdded(position);
        }
    }

    public void removeItem(int position) {
        mList.remove(position);
        if (mMockDataListener != null) {
            mMockDataListener.itemRemoved(position);
        }
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
