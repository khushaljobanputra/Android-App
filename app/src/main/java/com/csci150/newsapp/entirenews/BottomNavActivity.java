package com.csci150.newsapp.entirenews;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.csci150.newsapp.entirenews.utils.Utils;

public class BottomNavActivity extends AppCompatActivity {
    private final String TAG = "BottomNavActivity";

    private Fragment fragment;
    private FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_all_news:
                    fragment = AllNewsFragment.newInstance();
                    break;
                case R.id.navigation_recommended:
                    fragment = AllNewsFragment.newInstance();
                    break;
                case R.id.navigation_trending:
                    fragment = AllNewsFragment.newInstance();
                    break;
                case R.id.navigation_saved:
                    fragment = AllNewsFragment.newInstance();
                    break;
            }
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_container, fragment, null).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        fragmentManager = getFragmentManager();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (savedInstanceState == null) {
            Utils.print(TAG, "savedInstanceState == null");
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.main_container, AllNewsFragment.newInstance(), null)
                    .commit();
        }
    }
}
