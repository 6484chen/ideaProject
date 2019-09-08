package test0826;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName StreamApiTest
 * @Description 流
 * @Author 王琛
 * @Date 2019/8/27 11:34
 * @Version 1.0
 */


/*
流的特点：流不会修改原数据
1.流只是对数据进行计算，流不存储数据
2.流的创建是一次性的，关闭流后不能重写
3.流提供了可以串行计算的流
4，流是3个步骤：创建，流出，中止。


流提供：筛选、查找、判断、排序、映射、收集、规约
 */
public class StreamApiTest {
    List<Person> list = new ArrayList<>();

    @Before
    public void before(){
        list.add(new Person("张三",20));
        list.add(new Person("李四",21));
        list.add(new Person("王五",23));
        list.add(new Person("王五",20));
        list.add(new Person("王五",20));
    }


    @Test
    public void test(){
        //Arrays emp;
        Stream<Person> stream = list.stream();
        stream.filter((t)->t.getAge()==20).   //过滤相同元素
                limit(1)   //限制最大的个数
                .forEach(t-> System.out.println(t));
    }

    @Test
    public void test2(){
        Set<Person> collect = list.stream().collect(Collectors.toSet());

            System.out.println(collect);

    }
    @Test
    public void test03(){
        Stream<Person> stream = list.stream();
        //流的中间操作，map就是中间操作
        long count = stream.map((t)->t.getName().substring(0,2)).count();
        System.out.println(count);  //统计的个数


        //流结束后必须再次创建
        Stream<Person> stream1 = list.stream();
        //找出最大值和最小值
        //Optional<Person> first = stream1.sorted((p1, p2) -> p1.getAge() - p2.getAge()).findFirst();
        Optional<Person> last = stream1.sorted((p1, p2) -> p2.getAge() - p1.getAge()).findFirst();
        System.out.println("流计算结果："+"\n"+last.get());


        //Arrays提供的支持流,有不同的方法
        //对整数数组求和
        IntStream intStream = IntStream.range(1,101);  //创建了一个1-100 的数组
        //System.out.println(intStream.count());
        System.out.println(intStream.sum());
    }
}
