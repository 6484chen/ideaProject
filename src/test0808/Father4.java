package test0808;

public class Father4 {
    static {
        System.out.println("====父类static初始化代码块====");
    }
    {
        System.out.println("=====父类初始化代码块====");
    }
    public Father4(){
        System.out.println("=====父类构造函数====");

    }
    static {
        System.out.println("====父类static初始化代码块2====");
    }
    {
        System.out.println("=====父类初始化代码块2====");
    }
}
