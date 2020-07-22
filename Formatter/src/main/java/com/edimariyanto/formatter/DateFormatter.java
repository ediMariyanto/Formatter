package com.edimariyanto.formatter;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public static String SIMPLE_DATE_FORMAT(Date date, String pattern) {
        if (date != null) {
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            return formatter.format(date);
        }
        return "";
    }

    public static String SIMPLE_DATE_FORMAT(Long dateValue, String pattern) {
        if (dateValue != null) {
            Date date = new Date(dateValue);
            @SuppressLint("SimpleDateFormat")
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            return formatter.format(date);
        }
        return "";
    }
}
