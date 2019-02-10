package com.beloushkin.learning.android.heterogenousrecyclerview.mock;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class MockHolder extends RecyclerView.ViewHolder {
    private int mId;

    public MockHolder(@NonNull View itemView) {
        super(itemView);
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public void setOnClickListener(final MockAdapter.onItemClickListener listener) {

        //обращаемся ко всему элементу списка
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(mId);
            }
        });
    }
}
