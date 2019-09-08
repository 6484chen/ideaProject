package test0816;

public class Bank {
    private Customer [] customers;
    private int numberOfCustomer;

    public Bank(){
        customers = new Customer[10];
    }
    //添加用户



    public void addCustomer(String f,String l){
        Customer customer =new Customer(f,l);
        customers[numberOfCustomer] =customer;
        numberOfCustomer++;
    }
    //获取客户的个数

    public Customer getCustomer(int index) {
        //没有判断下标是否相同
        return customers[index];
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }
}
