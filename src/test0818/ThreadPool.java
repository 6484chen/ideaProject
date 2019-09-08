package test0818;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 *
 * 通过线程池创建线程
 *
 * @ClassName ThreadPool
 * @Description 线程池
 * @Author 王琛
 * @Date 2019/8/28 12:22
 * @Version 1.0
 */

class number implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class number1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        System.out.println(service.getClass());
        //设置线程属性
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;
        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime(20);

        service.execute(new number());  //适用于Runnable
        service.execute(new number1());  //适用于Runnable
        //关闭链接池
        service.shutdown();
    }
}
