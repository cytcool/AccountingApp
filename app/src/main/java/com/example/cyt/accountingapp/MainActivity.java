package com.example.cyt.accountingapp;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private MainViewPagerAdapter mainViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        viewPager = findViewById(R.id.viewpager);
        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.notifyDataSetChanged();
        viewPager.setAdapter(mainViewPagerAdapter);
        viewPager.setCurrentItem(mainViewPagerAdapter.getLastIndex());

    }


}
