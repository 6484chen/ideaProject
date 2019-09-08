package test0821;

import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName RefectTest01
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/21 14:54
 * @Version 1.0
 */
public class RefectTest01 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        /*//获取反射对象
        //1.通过具体类来加载class对象
        Class c1 =String.class;
        String str =(String)c1.newInstance();
        //2.通过实例来反射，通过运行时的对象获取对象的getClass（）
        Class c2 = "hekk".getClass();

        if(c1 == c2){
            System.out.println("c1 和c2 相同");
        }
        //3.通过已知的类全名加载
        Class c3 = Class.forName("java.lang.String");
        //4.通过类的加载器来加载
        ClassLoader classLoader =RefectTest01.class.getClassLoader();   //可以是任意一个类来获取加载器
        System.out.println(classLoader);
        Class c4 = classLoader.loadClass("test0821.Person");  //加载类返回的是一个类的类型
        Person person = (Person) c4.newInstance();  //无参构造函数

        //Constructor获取构造函数
        //调用有参构造函数
        Constructor constructor = c4.getDeclaredConstructor(String.class,int.class);
        Person o1=(Person) constructor.newInstance("zhangsan",20);
        System.out.println(o1);
        if(c1==c2 && c2 == c3){
            System.out.println("c1 c2 c3都一样");
        }*/

        //1.通过运行时类获取反射
        Class class1 = Person.class;
        //2.通过运行时对象获取反射
        Person person = new Person();
        Class class2 = person.getClass();
        //3.通过已知的类全名加载
        Class class3 = Class.forName("test0821.Person");
        //

    }
}
