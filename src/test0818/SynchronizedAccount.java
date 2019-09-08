package test0818;

/**
 *
 *
 *
 * @ClassName SynchronizedAccount
 * @Description 同步方法，同步通信
 * @Author 王琛
 * @Date 2019/8/28 8:52
 * @Version 1.0
 */
public class SynchronizedAccount {

    public static void main(String[] args) {
        Account1 account1 =new Account1();
        Customer1 customer1 = new Customer1(account1);
        Customer1 customer2 =new Customer1(account1);

        Thread t1 =new Thread(customer1);
        Thread t2 =new Thread(customer2);

        t1.setName("账户一");
        t2.setName("账户二");

        t1.start();
        t2.start();



    }
}

class Account1{
    private double balace;
    //存钱
    public synchronized void  drawMoney(double money){
        if(money >0){
            balace += money;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"账户余额为："+balace);
        }

    }
}

class Customer1 implements Runnable{
    private Account1 account;

    public Customer1(Account1 account) {
        this.account = account;
    }



    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {

            account.drawMoney(1000);

        }

    }
}
