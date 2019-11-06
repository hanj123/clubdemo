package clubgroup.clubdemo.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndString {

    public static String dateToString(Date date){
        System.out.println(date);
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        String dateStr = formatter.format(date);
        return dateStr;
    }

    public static Date stringToDate(String dateStr){

        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        Date strtodate = null;
        try {
            strtodate = formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return strtodate;
    }

//    public static void main(String[] args) {
////        String str = "2018-12-30";
////        Date date = stringToDate(str);
////        System.out.println(date);
//
//        Date date = new Date();
//        String s = dateToString(date);
//        System.out.println(s);
//    }
}
