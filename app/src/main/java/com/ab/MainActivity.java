package com.ab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("All ----=====---=","Hello");

        getTabs();
    }

    private void getTabs() {
        ViewPager myViewPager = findViewById(R.id.main_tabs_pager);
        CategoryAccessorAdapter myTabsAccessorAdapter = new CategoryAccessorAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(myTabsAccessorAdapter);
        TabLayout myTabLayout = findViewById(R.id.main_tabs);
        myTabLayout.setupWithViewPager(myViewPager);
        myTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
