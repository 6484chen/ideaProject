package test0808;

/**
 * @ClassName Person
 * @Description 多态性
 * @Author 王琛
 * @Date 2019/8/21 9:01
 * @Version 1.0
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printMesage(){
        System.out.println("name:"+name+",age:"+age);
    }

    public void show(){
        System.out.println("这是父类");
    }
}

class Man extends Person{
    private String sex;

    public Man(String name, int age, String sex) {
        super(name, age);
        this.sex = sex;
    }

    public void show(){
        System.out.println("这是子类");
    }

    public void print(){
        System.out.println("这个方法没有重写父类");
    }

    public static void main(String[] args) {
        Person person =new Man("张三",20,"男");
        person.printMesage();   //执行的父类，因为没有重写
        person.show();  //执行的子类
        //person.print();  错误写法
    }
}
