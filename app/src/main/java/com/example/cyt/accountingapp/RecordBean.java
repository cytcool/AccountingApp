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
        timeStamp = System.currentTimeMillis();
        date = DateUtil.getFormattedDate();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public RecordType getType() {
        return type;
    }

    public void setType(RecordType type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


}
