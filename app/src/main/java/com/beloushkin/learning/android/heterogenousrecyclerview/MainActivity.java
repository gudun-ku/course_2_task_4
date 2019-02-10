package com.beloushkin.learning.android.heterogenousrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.beloushkin.learning.android.heterogenousrecyclerview.mock.MockData;
import com.beloushkin.learning.android.heterogenousrecyclerview.mock.MockGenerator;

public class MainActivity extends AppCompatActivity {

    private Toast mToast;
    private final MockData mMockData = MockData.getInstance();
    private final MockGenerator mockGenerator = new MockGenerator(this);


    private void showToast(String msg) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, msg ,Toast.LENGTH_SHORT);
        mToast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, ListFragment.newInstance())
                    .commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_txt_item:
                showToast(item.getTitle().toString());
                mMockData.addItem(mockGenerator.generateTextInfo());
                return true;
            case R.id.add_img_item:
                showToast(item.getTitle().toString());
                mMockData.addItem(mockGenerator.generatePictureInfo());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
