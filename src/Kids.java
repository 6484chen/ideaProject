public class Kids extends ManKind{
    private int yearsOld;

    public Kids(int sex,int salary,int yearsOld){
        this.yearsOld=yearsOld;
        this.setSex(sex);
        this.setSalary(salary);
    }
    public void printAge(){
        System.out.println(yearsOld);
    }

    public static void main(String[] args) {
        Kids someKid = new Kids(1,1000,22);
        someKid.manOrWoman();
        someKid.employeed();
        someKid.printAge();
        if(someKid instanceof ManKind){
            System.out.println("true");
        }
    }
}
