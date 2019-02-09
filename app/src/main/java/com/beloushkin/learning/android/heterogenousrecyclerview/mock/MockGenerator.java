package com.beloushkin.learning.android.heterogenousrecyclerview.mock;

import android.content.Context;

import com.beloushkin.learning.android.heterogenousrecyclerview.CustomApplication;
import com.beloushkin.learning.android.heterogenousrecyclerview.R;

import java.lang.ref.WeakReference;
import java.util.Random;

public class MockGenerator {

    private static Random random = new Random();
    private static WeakReference<Context> contextWR;

    public MockGenerator(Context context) {
       contextWR = new WeakReference<>(context);
    }

    public static MockTextInfo generateTextInfo() {
        int id = random.nextInt(1000);
        int shardId = id % 10;
        String name = "no_name";
        String description = "no_description";

        Context context = contextWR.get();
        if (context != null) {
            name = context.getResources().getStringArray(R.array.names)[shardId];
            name = context.getResources().getStringArray(R.array.descriptions)[shardId];
        }

        return new MockTextInfo(name,description,id);
    }

    public static MockPictureInfo generatePictureInfo() {
        int id = random.nextInt(2000);
        int shardId = id % 10;
        String label = "no_label";
        String description = "no_description";

        Context context = contextWR.get();
        if (context != null) {
            label = context.getResources().getStringArray(R.array.labels)[shardId];
        }
        return new MockPictureInfo(label, "file:///android_asset/images/image_" + String.valueOf(shardId) + ".png");
    }
}
