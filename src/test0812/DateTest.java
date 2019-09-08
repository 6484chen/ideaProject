package test0812;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("MM月dd日yyyy年");
        String str = simpleFormatter.format(d1);
        System.out.println(str);
        String date1 = "07月12日2017年";
        try {
            Date d2 = simpleFormatter.parse(date1);


            System.out.println((d1.getTime()-d2.getTime())/1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
