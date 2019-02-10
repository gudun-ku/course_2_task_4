package com.beloushkin.learning.android.heterogenousrecyclerview.mock;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.beloushkin.learning.android.heterogenousrecyclerview.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MockAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> mItems;
    private final int ITEM_TEXT = 0;
    private final int ITEM_IMAGE = 1;

    public MockAdapter(List<Object> items){
        mItems = items;
    }

    @Override
    public int getItemViewType(int position) {
        if (mItems.get(position) instanceof MockTextInfo) {
            return ITEM_TEXT;
        } else if (mItems.get(position) instanceof MockPictureInfo) {
            return ITEM_IMAGE;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case ITEM_TEXT:
                View vTxt = inflater.inflate(R.layout.li_type_txt, viewGroup, false);
                viewHolder = new MockHolderText(vTxt);
                break;
            case ITEM_IMAGE:
                View vImg = inflater.inflate(R.layout.li_type_img, viewGroup, false);
                viewHolder = new MockHolderImage(vImg);
                break;
            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        switch (viewHolder.getItemViewType()) {
            case ITEM_TEXT:
                MockHolderText vhTxt = (MockHolderText) viewHolder;
                configureTextViewHolder(vhTxt, position);
                break;
            case ITEM_IMAGE:
                MockHolderImage vhImg = (MockHolderImage) viewHolder;
                configureImageViewHolder(vhImg, position);
                break;
            default:
                break;
        }
    }

    private void configureTextViewHolder(MockHolderText vh, int position) {
        MockTextInfo itemInfo = (MockTextInfo) mItems.get(position);
        if (itemInfo != null) {
            vh.getTexViewName().setText("Name: " + itemInfo.getName());
            vh.getTextViewDescription().setText("Description: " + itemInfo.getDescription());
            vh.getTextViewValue().setText(itemInfo.getValue());
            vh.setId(itemInfo.getId());
        }
    }

    private void configureImageViewHolder(MockHolderImage vh, int position) {
        MockPictureInfo itemInfo = (MockPictureInfo) mItems.get(position);
        if (itemInfo != null) {
            vh.getTextViewLabel().setText(itemInfo.getLabel());
            vh.setId(itemInfo.getId());
            ImageView v = vh.getImageViewPicture();
            v.setImageResource(R.drawable.ic_no_image);
            // work with picasso
            Picasso.with(v.getContext())
                    .load(itemInfo.getPictureUrl())
                    .into(v);
        }
    }



    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void addData(List<Object> items) {
        mItems.addAll(items);
        notifyDataSetChanged();
    }
    public void addItem(Object item) {
        mItems.add(item);
        notifyDataSetChanged();
    }

}
