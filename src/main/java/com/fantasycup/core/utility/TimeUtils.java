package com.fantasycup.core.utility;

import java.sql.Timestamp;
import java.util.Date;

public class TimeUtils {

    public static String getCurrentDateTime(){
        Date date= new Date();
        Timestamp ts = new Timestamp(date.getTime());
       // System.out.println("Current Time Stamp: " + ts);
        return ts.toString();

    }

    public static Timestamp CurrentTimeStamp(){
        Date date= new Date();
        Timestamp ts = new Timestamp(date.getTime());
       // System.out.println("Current Time Stamp: " + ts);
        return ts;

    }
}
