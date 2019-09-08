package test0821;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName PersonReflectTest
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/21 14:36
 * @Version 1.0
 */
public class PersonReflectTest {


    //反射之前,在person类之外不可以调用私有属性
    @Test
    public void test1(){
        Person person =new Person("张三",20);
        person.age=22;
        person.show();
        System.out.println(person.toString());

    }

    //反射之后,对Person的操作，可以操作Person类的私有属性
    @Test
    public void test2() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        //.class是对Class的实例
        Class clazz = Person.class;
        System.out.println(clazz.getName());  //返回class类所表示的实体（类、接口、数组类、基本类）的名称
        //1.通过反射，创建Person对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("张三",20);
        Person person =(Person)obj;
        System.out.println(person.toString());

        //2.通过反射，调用对象指定的属性和方法
        //调用属性
        Field age= clazz.getField("age");  //针对公有属性
        age.set(person,22);
        System.out.println(person.toString());

        //调用方法
        Method show =clazz.getDeclaredMethod("show");
        show.invoke(person);  //执行方法

        System.out.println("**************************************");


        //3.通过反射，调用类的私有结构，例如：私有属性，私有方法，私有构造器
        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);   //设置属性可以进行访问
        name.set(person,"王五");
        System.out.println(person);

        //调用私有构造器
        Constructor cons = clazz.getDeclaredConstructor(String.class);
        cons.setAccessible(true);
        Person p1 = (Person)cons.newInstance("老六");  //构造器返回的是该Class的一个实例
        System.out.println(p1);

        //调用私有方法
        Method showNation = clazz.getDeclaredMethod("showNation",String.class);  //先写方法名，再写参数类型
        showNation.setAccessible(true);
        showNation.invoke(person,"中国");

        //invoke（） 返回的类型是方法的返回类型
        String str = (String) showNation.invoke(person,"中国");
        System.out.println(str);


    }

}
