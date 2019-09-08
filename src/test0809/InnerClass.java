package test0809;

class B {
    private int a = 2;
    public void print(){
        System.out.println("B print ...."+a);
    }

    public B(int a) {
        System.out.println("B 构造函数"+a);
        this.a = a;
    }

    {
        System.out.println("B 代码段");
    }
    //内部类
    class A {
        private int bb = 1;

        public A(int bb) {
            System.out.println("A 构造函数");
            this.bb = bb;
        }
        {
            System.out.println("A 代码段");
        }
        public void print(){
            a = 1;
            System.out.println("A print ...."+a);
        }
    }

    class C extends A {

        public C(int bb) {
            super(bb);
        }
    }
}

public class InnerClass {
    public static void main(String[] args) {
       /* B b = new B(2);
        b.print();*/
        B.A a = new B(2).new A(3);
        a.print();

    }
}
