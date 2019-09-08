package test0818;

import java.util.Objects;

/**
 * @ClassName Account
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/27 8:38
 * @Version 1.0
 */
public class Account {
    private String IDcare;
    private double balance;

    public Account() {
    }

    public Account(String IDcare, double balance) {
        this.IDcare = IDcare;
        this.balance = balance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;

        if(IDcare == null){
            if(account.IDcare != null)
                return false;

        }
        return Double.compare(account.balance, balance) == 0 &&
                Objects.equals(IDcare, account.IDcare);
    }

    //重写hashcode（）
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((IDcare ==null)?0:IDcare.hashCode());
        long temp = Double.doubleToLongBits(balance);
        result = prime * result + (int)(temp^(temp>>>32));
        return result;
    }

    public String getIDcare() {
        return IDcare;
    }

    public void setIDcare(String IDcare) {
        this.IDcare = IDcare;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
