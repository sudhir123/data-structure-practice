package com.prac.home.tests.old;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateRange {
    public static void main(String[] args) {
        System.out.println(checkIdDateBetween90Days());
    }

    static boolean checkIdDateBetween90Days(){
        Date min = addDays(new Date(), -90), max= addDays(new Date(), +1);
        Date d= new Date();
        return d.compareTo(min) >= 0 && d.compareTo(max) <= 0;
    }

    public static Date addDays(Date date, Integer days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }
}
