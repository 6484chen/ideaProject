package test0818;

/**
 * @ClassName Productor
 * @Description 生产者
 * 将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，店员一次只能持有固定数量的产品(比如:20），
 * 如果生产者试图生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 * @Author 王琛
 * @Date 2019/8/26 21:38
 * @Version 1.0
 */

/*
这里可能出现两个问题：
        生产者比消费者快时；消费者会漏掉一些数据没有取到。
        消费者比生产者快时；消费者会取相同的数
 */
public class Productor implements Runnable {
    private Check check;

    public Productor(Check check){
        this.check=check;
    }
    @Override
    public void run() {
        System.out.println("生产者开始生产商品");

        while (true){
            try {
                Thread.sleep((int)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            check.addProduct();
        }

    }
}
