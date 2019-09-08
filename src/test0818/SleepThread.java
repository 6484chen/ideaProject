package test0818;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName SleepThread
 * @Description 线程sleep
 * @Author 王琛
 * @Date 2019/8/19 16:29
 * @Version 1.0
 */
public class SleepThread {
    public static void main(String[] args) throws InterruptedException {
        DateThread dateThread =new DateThread();
        Thread thread =new Thread(dateThread);
        thread.start();


    }
}

class DateThread implements Runnable{

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SimpleDateFormat simpleDateFormat =new SimpleDateFormat("hh:mm:ss");

            Date date = new Date();
            String str = simpleDateFormat.format(date);
            System.out.println(str);

        }
    }
}
