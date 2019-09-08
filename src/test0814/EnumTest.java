package test0814;

/**
 * 枚举类
 *
 */
public class EnumTest {
    public static void main(String[] args) {
        Car car = Car.REDCAR;
        Car car1 = Car.BLUECAR;
        car.getPrint();

        Bike b1 = Bike.BLUEBIKE;
        Bike b2 = Bike.GREENBIKE;
        b1.getPrint();
        System.out.println(b2.getName());   //返回对象的属性
        //Bike bike=b1;
        switch (b1){    //枚举类的对象名称
            case REDBIKE:    //枚举中的常量
                System.out.println("1");
                break;
            case BLUEBIKE:
                System.out.println("2");
                break;
            default:
                System.out.println(3);
        }
        Bike[] bikes = Bike.values();   //遍历枚举类中的各个值  //Art+Enter   Ctrl+Alt+V
        for (Bike bike : bikes) {
            System.out.println(bike);
        }
        System.out.println(Bike.values().length);  //返回枚举类的长度
        System.out.println(b2.toString());
        //Bike b3 = Bike.valueOf("BLUEBIKE");
        //System.out.println((b2.toString() == Bike.GREENBIKE);   错误写法
        System.out.println((Bike.valueOf("REDBIKE") == Bike.REDBIKE));  //valueOf中的字符串必须和枚举值相同

    }



}

/**
 * JDK1.5之前的
 * 这种创建的枚举类和单例模式的饿汉式一样，缺少静态函数后去，这里使用的是自己的公有变量
 */

class Car{
    //1.创建该列的静态常量对象
    public static final Car REDCAR = new Car();
    public static final Car BLUECAR = new Car("name","10");
    //2.创建私有构造函数
    private Car(){}

    private String carName;
    private String carAge;

    public Car(String carName, String carAge) {
        this.carName = carName;
        this.carAge = carAge;
    }
    public void getPrint(){
        System.out.println("name:"+carName+";carAge:"+carAge);
    }
}

enum Bike {    //枚举不可在继承，因为已经继承了Enum   bike extends Enum；可以实现接口
                                                                                    //可以实现某个枚举进行重写
    //约定必须卸载第一行，创建枚举变量
    //相当于 Bike REDBIKE = new Bike();
    REDBIKE("红色自行车","200"){
        public void start(){
            System.out.println("红色车在运行");
        }
                                                                                    },BLUEBIKE("蓝色自行车","200"),GREENBIKE("绿色自行车","200");  //约定必须卸载第一行，创建枚举变量
                                        //相当于 Bike REDBIKE = new Bike();
    //2.其他属性、函数都可以有，但构造函数必须有
    private String name;
    private String coust;
    //3.定义构造函数,默认为私有的
    Bike(String name,String coust) {
        this.name = name;
        this.coust = coust;
    }

    public void getPrint(){
        System.out.println("name:"+name+";coust:"+coust);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoust() {
        return coust;
    }

    public void setCoust(String coust) {
        this.coust = coust;
    }

    public void start(){
        System.out.println("车在运行");
    }
}
