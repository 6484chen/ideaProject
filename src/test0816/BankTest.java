package test0816;

public class BankTest {
    public static void main(String[] args) {
        Bank bank =new Bank();
        //创建客户
        bank.addCustomer("王","琛");
        //给客户一个账户
        bank.getCustomer(0).setAccount(new Account(1001,2000,0.012));
        //访问客户的消费
        bank.getCustomer(0).getAccount().withdraw(200);
        bank.getCustomer(0).getAccount().deposit(100);
        bank.getCustomer(0).getAccount().withdraw(2000);
        System.out.println(bank.getCustomer(0));
    }
}
