package test0819;

/**
 * @param
 * @author 王琛
 * @deception
 * @date 2019/8/17 9:52
 * @return
 */
public class Person {
    private String name;
    private int age;
    private String sex;

    public void info(){
        System.out.println("==父类==");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public static void main(String[] args) {
        Person person =new Person();

        //继承父类的方法
        Man man = new Man("teacher");
        //man.age = 20;  错误写法，由于父类已经私有化了，不能直接调用父类的私有属性，但在对内存中已经生成属性的位置

        //私有属性只能使用方法，保证了父类的封装性
        man.setName("张三");
        man.setAge(21);
        man.setSex("男");
        man.info();   //调用父类方法
        System.out.println("个人信息：姓名 "+man.getName()+" 性别 "+man.getSex()+" 年龄 "+man.getAge()+" 工作 "+man.getWork());
        man.show();
    }
}
/**
 * @param
 * @author 王琛
 * @deception  子类
 * @date 2019/8/17 9:52
 * @return
 */
class Man extends Person{
    private String work;

    public Man(){
    }

    public Man(String work) {
        this.work = work;
    }

    public void show(){
        System.out.println("my work is"+work);
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}