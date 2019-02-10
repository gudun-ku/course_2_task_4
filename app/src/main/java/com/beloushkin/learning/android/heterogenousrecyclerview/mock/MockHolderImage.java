package com.beloushkin.learning.android.heterogenousrecyclerview.mock;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.beloushkin.learning.android.heterogenousrecyclerview.R;

public class MockHolderImage extends MockHolder {

    private TextView tvLabel;
    private ImageView ivPicture;

    public MockHolderImage(@NonNull View itemView) {
        super(itemView);
        tvLabel = itemView.findViewById(R.id.tv_label);
        ivPicture = itemView.findViewById(R.id.iv_picture);
    }

    public TextView getTextViewLabel() {
        return tvLabel;
    }

    public ImageView getImageViewPicture() {
        return ivPicture;
    }

}
