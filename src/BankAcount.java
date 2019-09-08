public class BankAcount {
    private int acount;
    private String passwd;
    private double balance;
    public static double interestRate;
    public static double minBalance;
    public static int total=0;
    public BankAcount(){
        total++;
        acount=total;
    }
    public BankAcount( String passwd, double balance){
        this();
        this.balance = balance;
        this.passwd = passwd;
    }
    public int getAcount() {
        return acount;
    }

    public void setAcount(int acount) {
        this.acount = acount;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAcount.interestRate = interestRate;
    }

    public static double getMinBalance() {
        return minBalance;
    }

    public static void setMinBalance(double minBalance) {
        BankAcount.minBalance = minBalance;
    }

    @Override
    public String toString() {
        return "BankAcount{" +
                "acount=" + acount +
                ", passwd='" + passwd + '\'' +
                ", balance=" + balance +
                '}';
    }
}
