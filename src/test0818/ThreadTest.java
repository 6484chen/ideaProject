package test0818;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/19 14:57
 * @Version 1.0
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //myThread.run 不是多线程
        myThread.setName("线程一");
        myThread.start();  //创建线程，内部等待OS调度；start（）有启动线程和调用run（）的功能
        myThread.run();   //该方法只是启用了run方法，没有启动线程
       // myThread.yield();   //线程让步，暂停当前线程，之暂停一会儿
        try {
            myThread.join();   //等待此线程执行完，才可以让其他线程执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        InterfaceThread interfaceThread = new InterfaceThread();  //1.实现接口
        Thread thread = new Thread(interfaceThread);    //2.构造Thread函数
        thread.setName("线程二");  //设置线程名称
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.setPriority(Thread.NORM_PRIORITY+4);

        for (int i = 0; i < 1000; i++) {
            System.out.println("main线程："+i+Thread.currentThread().getName());
        }

    }
}


class MyThread extends Thread {

    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("子线程：" + i + Thread.currentThread().getName());
        }
    }
}

class InterfaceThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Runnable线程:"+i+Thread.currentThread().getName());
        }
    }
}

