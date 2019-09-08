package test0821;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @ClassName PersonAllReflectTest
 * @Description 通过反射获取属性、方法、接口、注释等
 * @Author 王琛
 * @Date 2019/8/21 15:45
 * @Version 1.0
 */
public class PersonAllReflectTest {
    public static void main(String[] args) {
        //创建反射对象
        Class<Person> c1 = Person.class;
        //Field 的使用
        Field[] fields = c1.getDeclaredFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();  //获取属性的修饰符,默认为整数
            System.out.println(modifiers);
            System.out.println(" "+ Modifier.toString(modifiers)+" ");
            //获取类型
            Class<?> fieldType = field.getType();
            System.out.println("返回类型"+fieldType);
            //获取属性名称
            String name = field.getName();
            System.out.println("属性的名称："+name);
        }
        //获取方法
        Method[] methods =c1.getMethods();
        for (Method method : methods) {

        }

    }


}
