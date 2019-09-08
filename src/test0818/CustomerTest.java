package test0818;

/**
 * @ClassName CustomerTest
 * @Description 消费者问题
 * @Author 王琛
 * @Date 2019/8/26 21:57
 * @Version 1.0
 */
public class CustomerTest {
    public static void main(String[] args) {
        Check check = new Check();
        Thread proThread = new Thread(new Productor(check));
        Thread cusThread = new Thread(new Customer(check));
        proThread.start();
        cusThread.start();
    }
}
