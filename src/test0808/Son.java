package test0808;

public class Son extends Father4 {
    static {
        System.out.println("====子类static初始化代码块====");
    }
    {
        System.out.println("=====子类初始化代码块====");
    }
    public Son(){
        System.out.println("=====子类构造函数====");

    }
    static {
        System.out.println("====子类static初始化代码块2====");
    }
    {
        System.out.println("=====子类初始化代码块2====");
    }

    public static void main(String[] args) {
        Father4 father4 = new Son();
        Son son = new Son();
    }
}
