package com.example.cyt.accountingapp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CYT on 2018/1/26.
 */

public class DateUtil {

    public static String getFormattedTime(long timeStamp){

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        return formatter.format(new Date(timeStamp));

    }

    public static String getFormattedDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(new Date());
    }
}
