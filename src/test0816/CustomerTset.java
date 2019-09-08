package test0816;

public class CustomerTset {
    public static void main(String[] args) {
        Customer customer =new Customer("Jane","Smith");
        Account account =new Account(1000,2000.0,0.0123);
        customer.setAccount(account);
        customer.getAccount().withdraw(960);

        customer.getAccount().deposit(100);
        customer.getAccount().withdraw(2000);
        System.out.println(customer);

    }
}
