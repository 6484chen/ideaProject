package test0814;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        List<Integer> list1 =new LinkedList<Integer>();

        list.add("aaa");
        //list.add(12);  类型不匹配，报错
        list.add("3244");
        for (String s : list) {
            System.out.println("list<String>:"+s);
        }

        list1.add(23);
        list1.add(344);
        for (Integer integer : list1) {
            System.out.println("list1<Integer>:"+integer);
        }
    }
}
