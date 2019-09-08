package test0812;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest {
    public static void main(String[] args) {
        LocalDate localDate =LocalDate.now();
        Month month = localDate.getMonth();
        do {

            int year = localDate.getYear();
            int[] months = monthDay(year);
            int days = months[localDate.getMonthValue()];
            printBody(year, month, days);
            Scanner sc  = new Scanner(System.in);
            System.out.println("输入向前或向后几个月，格式为（1）向后一个月，（-1）为向前一个月");
            int i = sc.nextInt();
            LocalDate localDate1 = LocalDate.now();
            localDate1.withMonth(7);
            System.out.println(localDate1.toString());

            localDate.withMonth(month.getValue()-1);
            System.out.println(localDate.toString());
        }while (true);
    }

    //1.判断是闰年还是平年
    public static boolean isYear(int year){
        if((year % 4 ==0 && year % 100 != 0) || year % 400 == 0){
            return true;  //
        }
        return false;
    }
    //2.根据年份输出当年每个月的天数
    public static int[] monthDay(int year){
        int[] leapDay = {31,29,31,30,31,30,31,31,30,31,30,31,30};
        int[] noLeapDay = {31,28,31,30,31,30,31,31,30,31,30,31,30};
        if(isYear(year)){
            return leapDay;
        }else{
            return noLeapDay;
        }
    }
   /* //3.获取当月的英文对照
    public static String englishMonth(int month){
        String monthName = "";
        switch(month) {
            case 1: monthName = "January"; break;
            case 2: monthName = "February"; break;
            case 3: monthName = "March"; break;
            case 4: monthName = "April"; break;
            case 5: monthName = "May"; break;
            case 6: monthName = "June"; break;
            case 7: monthName = "July"; break;
            case 8: monthName = "August"; break;
            case 9: monthName = "September"; break;
            case 10: monthName = "October"; break;
            case 11: monthName = "November"; break;
            case 12: monthName = "December";
        }
        return monthName;
    }*/
    //4.打印日历头部
    public static void printHead(int year,Month month){
        System.out.println(month+"     "+ year+"年"+(month.getValue())+"月");
        System.out.println("--------------------------------");
        System.out.println("Sun Mon Tue Wed Thu Fri Sat ");
    }

    //5.循环输出日期
    public static void printBody(int year,Month month,int day){
        printHead(year,month);
        int count =1;
        Calendar calendar =Calendar.getInstance();

        calendar.set(year,month.getValue()-1,1);  //设置日期每月的一号

        int start = calendar.getTime().getDay();
        for (int i = 0;i < 7;i++){
            if(i<start){
                System.out.print("\t");
            }else{
                System.out.print(count+"\t");
                count++;
                day--;
            }
        }
        System.out.println();
        while(day>0) {
            for (int i = 1; i <= 7; i++) {
                System.out.print(count+"\t");
                count++;
                day--;
                if(day < 0){
                    break;
                }
            }
            System.out.println();
        }
    }
}
