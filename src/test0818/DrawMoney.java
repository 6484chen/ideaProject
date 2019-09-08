package test0818;

/**
 * @ClassName DrawMoney
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/27 8:43
 * @Version 1.0
 */
public class DrawMoney implements Runnable{
    private Account account;
    private double withDraw;

    public void setWithDraw(double withDraw) {
        this.withDraw = withDraw;
    }

    public DrawMoney(Account account,double withDraw){
        this.account = account;
        this.withDraw = withDraw;
    }

    @Override
    public void run() {
        synchronized (account){
            if(account.getBalance() - this.withDraw < 0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("提款成功！"+withDraw);
                account.setBalance(account.getBalance()-withDraw);
            }notifyAll();
        }
    }
}
