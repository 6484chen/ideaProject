package test0820;

/**
 * @ClassName Communication
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/20 10:53
 * @Version 1.0
 */
public class Communication {
    public static void main(String[] args) {
        CommunicationDemo communicationDemo =new CommunicationDemo();
        Thread t1 = new Thread(communicationDemo);
        Thread t2 = new Thread(communicationDemo);
        t1.setName("线程一");
        t2.setName("线程二");
        t1.start();
        t2.start();
        communicationDemo.show();
    }
}


class CommunicationDemo implements Runnable{
    int i=1;

    public void run(){
        while(true){
            synchronized (this) {
                this.show();
                this.show2();
            }
        }


        /*while (true){
            synchronized (this){
                this.notify();  //先通知
                if(i<=100){

                    System.out.println(Thread.currentThread().getName()+"打印i：" + i++);
                }else{
                    break;
                }

                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*/


    }
    public synchronized  void  show(){
        System.out.println("SHow1");
    }
    public synchronized  void  show2(){
        System.out.println("SHoww");
    }
}
