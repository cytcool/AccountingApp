package com.example.cyt.accountingapp;

import java.util.UUID;

/**
 * Created by CYT on 2018/1/26.
 */

public class RecordBean {

    public enum RecordType{
        RECORD_TYPE_EXPENSE,RECORD_TYPE_INCOME
    }

    private double amount;
    private RecordType type;
    private String category;
    private String remark;
    private String date;
    private long timeStamp;

    private String uuid;

    public RecordBean(){
        uuid = UUID.randomUUID().toString();
    }
}
