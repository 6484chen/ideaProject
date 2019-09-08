public class BankAcountTest {
    private BankAcountTest(){};
    private static BankAcountTest bankAcountTest = new BankAcountTest();
    public static BankAcountTest getInstance(){
        return bankAcountTest;
    }
    /*private static BankAcountTest bankAcountTest1 = null;
    public static BankAcountTest getInstance(){
        if (bankAcountTest1 == null){
            bankAcountTest = new BankAcountTest();
        }
        return bankAcountTest1;
    }*/



    public static void main(String[] args) {
        System.out.println(bankAcountTest);
    }
}
