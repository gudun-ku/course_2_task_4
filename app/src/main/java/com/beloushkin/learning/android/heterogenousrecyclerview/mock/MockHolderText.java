package com.beloushkin.learning.android.heterogenousrecyclerview.mock;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.beloushkin.learning.android.heterogenousrecyclerview.R;

public class MockHolderText extends RecyclerView.ViewHolder {

    private TextView tvName;
    private TextView tvDescription;
    private TextView tvValue;
    private int mId;

    public MockHolderText(@NonNull View itemView) {
        super(itemView);

        tvName = itemView.findViewById(R.id.tv_name);
        tvDescription = itemView.findViewById(R.id.tv_description);
        tvValue = itemView.findViewById(R.id.tv_value);
    }

    public TextView getTexViewName() {
        return tvName;
    }

    public TextView getTextViewDescription() {
        return tvDescription;
    }

    public TextView getTextViewValue() {
        return tvValue;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }
    /*
    public void setListener(final MockAdapter.onItemClickListener listener) {
        //обращаемся ко всему элементу списка
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(mId);
            }
        });
    }
    */

}
