package test0818;

/**
 *
 * wait（） 和 notify（） notifyAll();只能放在同步代码中
 *这三个方法只能是由object来调用
 * sleep可以放在任意位置，sleep不会释放锁，wait会释放锁
 *
 *
 * @ClassName Synchronized
 * @Description 让线程一和线程二分别打印数组1-100，相互通知
 * @Author 王琛
 * @Date 2019/8/26 20:52
 * @Version 1.0
 */
public class Synchronized {
    public static void main(String[] args) {
        Syn s = new Syn();
        Thread thread = new Thread(s);
        thread.setName("线程一");
        Thread thread1 = new Thread(s);
        thread1.setName("线程二");
        thread.start();
        thread1.start();
    }
}

class Syn implements Runnable{
    int i = 1;

    @Override
    public void run() {

        while (true){
            synchronized (this){  //此时为线程一占用锁（对象），线程二进不来
                notify();  //通知了线程二，但是当前资源被线程一占用，线程二无法抢占资源
                if(i<=100){
                    System.out.println(Thread.currentThread().getName()+":"+i++);
                }else{
                    System.out.println("hello over");
                    break;
                }
                //notify();  //如果放在这里的话，运行停止不了
                try {
                    wait();  //线程一释放资源,让线程一进入等待状态，必须要其他线程唤醒。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } //线程一结束后，线程二进来，继续通知线程一
            notifyAll();
        }

    }
}
