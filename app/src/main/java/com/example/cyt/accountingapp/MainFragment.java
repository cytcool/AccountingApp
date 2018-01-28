package com.example.cyt.accountingapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by CYT on 2018/1/28.
 */

public class MainFragment extends Fragment {

    private View rootView;
    private TextView textView;
    private ListView listView;

    private String date = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main,container,false);
        initView();
        return rootView;
    }

    private void initView(){
        textView = rootView.findViewById(R.id.day_text);
        listView = rootView.findViewById(R.id.listView);
        textView.setText(date);
    }
}
