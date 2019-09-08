package test0816;

public class BoyGirlTest {
    public static void main(String[] args) {
        Boy boy =new Boy("罗密欧",19);
        Girl girl =new Girl ("朱丽叶",20);
        boy.marry(girl);
        girl.marry(boy);
        boy.shout();
        Girl girl1 =new Girl("祝英台",23);
        int k =girl.compare(girl1);
        if(k < 0){
            System.out.println(girl.getName()+"小");
        }else{
            System.out.println(girl1.getName()+"大");
        }
    }
}
