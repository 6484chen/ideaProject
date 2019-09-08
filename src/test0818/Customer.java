package test0818;

/**
 * @ClassName Customer
 * @Description 消费者
 * @Author 王琛
 * @Date 2019/8/26 21:51
 * @Version 1.0
 */
public class Customer implements Runnable {

    private Check check;

    public Customer(Check check){
        this.check=check;
    }

    @Override
    public void run() {
        System.out.println("顾客开始消费");
        while (true){
            try {
                Thread.sleep((int)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            check.getProduct();   //为啥只能放在while里面
        }
    }
}
