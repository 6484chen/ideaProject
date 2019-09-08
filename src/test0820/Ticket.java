package test0820;

/**
 * @ClassName Ticket
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/20 9:36
 * @Version 1.0
 */
public class Ticket  {
    public static void main(String[] args) {
        TicketDemo ticketDemo = new TicketDemo();   //这里确定只能为一个对象
        Thread thread1 =new Thread(ticketDemo);
        Thread thread2 =new Thread(ticketDemo);
        Thread thread3 =new Thread(ticketDemo);
        thread1.setName("窗口1");  //线程不同步
        thread2.setName("窗口2");
        thread3.setName("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TicketDemo implements Runnable{
    private int tick = 100;
    public void run() {
        while (true) {
            //同步代码段，互斥的对象，  //只能有一个线程访问
            synchronized (this) {   //互斥锁
                if (tick > 0) {
                    try {
                        Thread.sleep(1000);  //为了显示效果
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程名称：" + Thread.currentThread().getName() + "》》tick票：" + tick--);
                } else {
                    break;
                }
            }
        }
    }

}