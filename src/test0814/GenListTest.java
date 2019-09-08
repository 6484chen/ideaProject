package test0814;

import java.util.ArrayList;
import java.util.List;

public class GenListTest {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list.add("aaa");
        list.add("bb");
        list1.add(23);
        list1.add(232);

        getPrint(list);
        getPrint(list1);
    }

    public static void getPrint(List<?> list){
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public static void getPrint1(List<? extends Number> list){  //带有限制的泛型，继承父类,只允许number和number子类调用
        for (Object o : list) {
            System.out.println(o);
        }
    }
    public static void getPrint2(List<? super Number> list){  //带有限制的泛型，只允许number和number父类调用
        for (Object o : list) {
            System.out.println(o);
        }
    }
    public static void getPrint3(List<? extends Comparable> list){  //带有限制的泛型，只允许number和number父类调用
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
