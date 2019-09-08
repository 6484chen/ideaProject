package test0814;

public class AnotationPerson {
    private String name;
    @Override
    public String toString(){
        return "name:"+name;
    }
    @MyTrger
    public void getPrint(String a){
        System.out.println(a);
    }

    public static void main(String[] args) {
        AnotationPerson a = new AnotationPerson();
        a.getPrint("c");
    }
}
