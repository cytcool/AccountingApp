package com.example.cyt.accountingapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private MainViewPagerAdapter mainViewPagerAdapter;

    private TickerView amountText;
    private TextView dateText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        amountText = findViewById(R.id.amount_text);
        amountText.setCharacterList(TickerUtils.getDefaultNumberList());
        dateText = findViewById(R.id.day_text);

        viewPager = findViewById(R.id.viewpager);
        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.notifyDataSetChanged();
        viewPager.setAdapter(mainViewPagerAdapter);
        viewPager.setOnPageChangeListener(this);
        viewPager.setCurrentItem(mainViewPagerAdapter.getLastIndex());

        findViewById(R.id.btn_addrecord).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddRecordActivity.class);
                startActivityForResult(intent,1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mainViewPagerAdapter.reload();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
            String amount = String.valueOf(mainViewPagerAdapter.getTotalCost(position)) + " ";
            amountText.setText(amount);
            String date = mainViewPagerAdapter.getDateStr(position);
            dateText.setText(DateUtil.getWeekDay(date));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
