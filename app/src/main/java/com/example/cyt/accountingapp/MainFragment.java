package com.example.cyt.accountingapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by CYT on 2018/1/28.
 */

@SuppressLint("ValidFragment")
public class MainFragment extends Fragment {

    private View rootView;
    private TextView textView;
    private ListView listView;

    private LinkedList<RecordBean> records = new LinkedList<>();

    private ListViewAdapter listViewAdapter;

    private String date = "";

    @SuppressLint("ValidFragment")
    public MainFragment(String date){
        this.date = date;
        records = GlobalUtil.getInstance().databaseHelper.readRecords(date);
    }

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
        listViewAdapter = new ListViewAdapter(getContext());
        reload();
        listView.setAdapter(listViewAdapter);
        textView.setText(DateUtil.getDateTitle(date));

    }

    public void reload() {
        records = GlobalUtil.getInstance().databaseHelper.readRecords(date);
        listViewAdapter.setData(records);

        if (listViewAdapter.getCount()>0){
            rootView.findViewById(R.id.no_record_layout).setVisibility(View.INVISIBLE);
        }
    }

    public int getToatlCost() {
        double amount = 0;
        for (RecordBean record:records
             ) {
            if (record.getType() == 1){
                amount += record.getAmount();
            }
        }
        return (int)amount;
    }
}
