package com.example.cyt.accountingapp;

import android.content.Context;

/**
 * Created by CYT on 2018/1/31.
 */

public class GlobalUtil {

    private static GlobalUtil instance;

    public RecordDataBaseHelper dataBaseHelper;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
        dataBaseHelper = new RecordDataBaseHelper(context,RecordDataBaseHelper.DB_NAME,null,1);
    }

    private Context context;

    public static GlobalUtil getInstance(){
        if (instance == null){
            instance = new GlobalUtil();
        }
        return instance;
    }
}
