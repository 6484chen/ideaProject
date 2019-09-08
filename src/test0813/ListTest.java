package test0813;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        for (Object o : list) {
            System.out.println(o);
        }
        //获取第一个元素
        list.get(0);
        System.out.println(list.get(1));

        //2.类明获取创建对象
        LinkedList linkedList = new LinkedList();
        linkedList.add("AAA");
        linkedList.add("BBB");
        linkedList.addFirst("aaa");  //加到链表首部
        for (Object lLo : linkedList) {   //list加入的对象为Object类型
            System.out.println(lLo);
        }
    }
}
