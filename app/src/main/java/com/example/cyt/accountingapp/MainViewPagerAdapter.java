package com.example.cyt.accountingapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.LinkedList;

/**
 * Created by CYT on 2018/1/29.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter{

    LinkedList<MainFragment> fragments = new LinkedList<>();
    LinkedList<String> dates = new LinkedList<>();


    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragments();
    }

    private void initFragments(){

        dates = GlobalUtil.getInstance().databaseHelper.getAvaliableDate();

        for (String date:dates) {
            MainFragment fragment = new MainFragment(date);
            fragments.add(fragment);
        }
    }

    public int getLastIndex(){
        return fragments.size() - 1;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
