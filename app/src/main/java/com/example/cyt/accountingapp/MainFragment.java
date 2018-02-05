package com.example.cyt.accountingapp;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by CYT on 2018/1/28.
 */

@SuppressLint("ValidFragment")
public class MainFragment extends Fragment implements AdapterView.OnItemLongClickListener {

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

        listView.setOnItemLongClickListener(this);

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

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        showDialog(position);
        return false;
    }

    private void showDialog(int index){
        final String[] options = {"Remove","Edit"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        final RecordBean selectedRecord = records.get(index);

        builder.create();

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // which = 0 -> Remove
                // which = 1 -> Edit
                if (which == 0){
                    String uuid = selectedRecord.getUuid();
                    GlobalUtil.getInstance().databaseHelper.removeRecord(uuid);
                    reload();
                }else if(which == 1){

                }

            }
        });

        builder.setNegativeButton("Cancel",null);
        builder.create().show();
    }
}
