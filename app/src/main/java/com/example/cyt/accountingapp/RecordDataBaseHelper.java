package com.example.cyt.accountingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;

/**
 * Created by CYT on 2018/1/26.
 */

public class RecordDataBaseHelper extends SQLiteOpenHelper{

    public static final String DB_NAME = "Record";

    public static final String CREATE_RECORD_DB = "create table Record("
            + "id integer primary key autoincrement"
            + "uuid text,"
            + "type integer,"
            + "category text,"
            + "remark text,"
            + "amount double,"
            + "time integer,"
            + "date date)";

    public RecordDataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_RECORD_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addRecord(RecordBean bean){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("uuid",bean.getUuid());
        values.put("type",bean.getType());
        values.put("category",bean.getCategory());
        values.put("remark",bean.getRemark());
        values.put("amount",bean.getAmount());
        values.put("date",bean.getDate());
        values.put("time",bean.getTimeStamp());
        db.insert(DB_NAME,null,values);
    }

    public void removeRecord(String uuid){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(DB_NAME,"uuid = ?",new String[]{uuid});
    }

    public void editRecord(String uuid,RecordBean record){
        removeRecord(uuid);
        record.setUuid(uuid);
        addRecord(record);
    }

    public LinkedList<RecordBean> readRecords(String dateStr){
        LinkedList<RecordBean> records = new LinkedList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select DISTINCE * from Record where date = ? order by time asc",new String[]{dateStr});

        if (cursor.moveToFirst()){

            do {
                String uuid = cursor.getString(cursor.getColumnIndex("uuid"));
                int type = cursor.getInt(cursor.getColumnIndex("type"));
                String category = cursor.getString(cursor.getColumnIndex("category"));
                String remark = cursor.getString(cursor.getColumnIndex("remark"));
                double amount = cursor.getDouble(cursor.getColumnIndex("amount"));
                String date = cursor.getString(cursor.getColumnIndex("date"));
                long timeStamp = cursor.getLong(cursor.getColumnIndex("timeStamp"));

                RecordBean record = new RecordBean();
                record.setUuid(uuid);
                record.setAmount(amount);
                record.setCategory(category);
                record.setDate(date);
                record.setRemark(remark);
                record.setTimeStamp(timeStamp);
                record.setType(type);

                records.add(record);


            }while (cursor.moveToNext());
        }

        cursor.close();
        return records;
    }

    public LinkedList<String> getAvaliableDate(){
        LinkedList<String> dates = new LinkedList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select DISTINCE * from Record order by date asc",new String[]{});

        if (cursor.moveToFirst()){

            do {
                String date = cursor.getString(cursor.getColumnIndex("date"));

                if (!dates.contains(date)){
                    dates.add(date);
                }

            }while (cursor.moveToNext());
        }
        cursor.close();
        return dates;
    }
}
