package test0818;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName SynchronizedLock
 * @Description Lock锁
 * @Author 王琛
 * @Date 2019/8/28 14:31
 * @Version 1.0
 */
public class SynchronizedLock {

    public static void main(String[] args) {
        ThreadLock threadLock =new ThreadLock();

        Thread t1 =new Thread(threadLock);
        Thread t2 =new Thread(threadLock);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}

class ThreadLock implements Runnable{
    int i=0 ;
    private ReentrantLock reentrantLock = new ReentrantLock();
    @Override
    public void run() {

        while (true){

            //手动上锁
            reentrantLock.lock();
                if(i<=100){
                    System.out.println(Thread.currentThread().getName()+":"+i++);
                }else{
                    System.out.println("hello over");
                    break;
                }
                //手动解锁
            reentrantLock.unlock();

        }
    }
}
