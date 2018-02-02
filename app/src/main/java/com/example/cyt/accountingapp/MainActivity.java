package com.example.cyt.accountingapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    private ViewPager viewPager;
    private MainViewPagerAdapter mainViewPagerAdapter;

    private Button btnAddRecord;




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

        findViewById(R.id.btn_addrecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddRecordActivity.class);
                startActivity(intent);
            }
        });
    }



}
