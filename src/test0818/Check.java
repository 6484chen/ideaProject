package test0818;

/**
 * @ClassName Check
 * @Description 销售员
 * @Author 王琛
 * @Date 2019/8/26 21:42
 * @Version 1.0
 */
public class Check {
    private int product = 0;
    //同步方法
    public synchronized void addProduct(){
        if(product > 20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            product++;
            System.out.println("生产者生产了"+product+"个产品");
        }

        //通知
        notifyAll();
    }

    public synchronized void getProduct(){
        if(this.product<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            product--;
            System.out.println("顾客取走了"+product+"个产品");
        }

        notifyAll();
    }
}
