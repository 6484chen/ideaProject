package test0816;

public class Account {
    private int id;
    private double balance;
    private double annuallnterestRate;

    public Account(int id, double balance, double annuallnterestRate) {
        this.id = id;
        this.balance = balance;
        this.annuallnterestRate = annuallnterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    //取钱
    public void withdraw(double amount){
        if(amount > this.balance){
            System.out.println("取钱失败，余额不足！");
        }else{
            this.balance = this.balance -amount;
            System.out.println("成功取钱"+amount+"元");
        }
    }
    //存钱
    public void deposit(double amount){
        if (amount < 100){
            System.out.println("存钱失败");
        }else{
            this.balance = this.balance + amount;
            System.out.println("成功存钱"+amount+"元");
        }

    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annuallnterestRate=" + annuallnterestRate +
                '}';
    }
}
