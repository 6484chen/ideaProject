package test0809;


public class TestException {
    public static void main(String[] args) {
        /*int a = 0b100;
        int b = 110;
        int c = 0127;
        int d = 0x110;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);*/

        /*String s = "132";
        int a = (int)s;*/
        int a = 10;
        int b = 20;
        //方式一
        int temb = a;
        a= b;
        b = temb;
        //方式二   好处：不需要定义临时变量，占用内存小
        //         坏处：相加可能超出存储范围；只能适用于数值类型
        a = a + b;
        b = a - b;
        a= a - b;

        try {
            boolean flag = true;
           /* char b = 'a';
            char c = (char)( b+10);
            System.out.println(c);*/
            System.out.println("aaa"+flag);
            System.out.println(10+10+"bbb");     //输出为20bbb
            System.out.println(10+"bbb"+10);     //输出10bbb10
            System.out.println("bbb"+10+10);     //输出bbb1010
        } catch(Exception e){
            System.out.println(10+10+"bbb");
        }
    }



}
