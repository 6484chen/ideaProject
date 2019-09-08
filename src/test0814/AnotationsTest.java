package test0814;

import java.lang.annotation.*;

public class AnotationsTest {
    @MyAnotations
    private String name;
    @MyAnotations
    public void getPrint(){

    }
}
//创建自定义的注解
//4个原注解，JDK提供的
@Retention(RetentionPolicy.RUNTIME)  //说明注解的存在时间和范围，source、class【编译是有效】、runtime【运行时有效】
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})  //表示注解使用的范围：类、方法、属性、参数等的注解
 @Inherited  //表示被注解的类，子类具有继承性
@Documented  //文档注解
@interface MyAnotations{
    String value() default "hello";
    String [] length ={"1","2"};
}
