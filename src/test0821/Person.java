package test0821;

/**
 * @ClassName Person
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/21 14:34
 * @Version 1.0
 */
public class Person {

    private String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("有参构造函数");
    }

    private Person(String name){
        this.name = name;
    }

    public Person() {
        System.out.println("无参构造函数");
    }

    public void show(){
        System.out.println("公有方法");
    }

    private String showNation(String nation){
        System.out.println("我的国籍是："+nation);
        return nation;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
