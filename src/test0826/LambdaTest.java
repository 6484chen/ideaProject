package test0826;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName LambdaTest
 * @Description Lambda测试
 * @Author 王琛
 * @Date 2019/8/27 10:17
 * @Version 1.0
 */
//函数式接口，只能有一个抽象方法接口，可以有多个非抽象方法接口
@FunctionalInterface
interface FilterTest<T>{
    boolean test(T a);

    //非抽象接口
    default void test1(){

    }
}

public class LambdaTest {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("zhangsan");
        list1.add("lisi");

        //常规方法
//        List<String > tmp = filter1(list1, new FilterTest<String>() {
//            @Override
//            public boolean test(String a) {
//                if(a.length()<5)
//                    list1.add(a);
//                return
//                        false;
//            }
//        });

        //lambda表达式
        List<String > tmp = filter1(list1,a -> a.length()<5);
        List<String > tmp1 = filter1(list1,a -> a.equals("lisi") );
        List<String > tmp2 = filter1(list1,a -> true );  //输出所有元素
        //打印
        for (String s : tmp2) {
            System.out.println(s);
        }

    }
    //策略设计模式
    //筛选集合
    public static List<String> filter1(List<String> list, FilterTest<String> filterTest) {
        List<String> list1 = new ArrayList<>();
        for (String s : list) {
            if(filterTest.test(s))
                list1.add(s);
        }
        return list1;
    }

    //使用java内置的函数接口，消费者类型
    public void  filter2(List<String> list, Consumer<String> consumer){
        for (String s : list) {
            consumer.accept(s);  //这里只是使用，没有返回值，仅仅使用消费者接口
            //list.add(s);
        }
    }

    @Test
    public void test3(){
        List<String> list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        filter2(list,(s)-> System.out.println(s.toUpperCase()));  //变成大写
    }



    //比较大小
    public void CompareTest(){
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        //lambda表达式

        Comparator<String> com2 = (o1,o2) -> o1.compareTo(o2);
    }
}


