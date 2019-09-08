package test0813;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set set = new HashSet();
        ListTest listTest = new ListTest();
       /* set.add("aa");
        set.add("ab");
        set.add("aaa");
        set.add(9);
        set.add(0);
        set.add("aaa");*/   //不可以添加重复的
        //需要重写StudentList中的HansCode（），否则会加入相同的对象。
        set.add(new StudentList("123","wang","1234"));
        set.add(new StudentList("123","wang","1234"));  //在添加的时候会调用已经添加的元素进行比较
        //为啥这里的hansCode会相同？？？？
        for (Object o : set) {
            System.out.println("aaa:"+o.hashCode());
            System.out.println(o);
        }

        System.out.println("--------------------------");
        //linkedHashSet 可以维护好哈希的插入顺序，使用的是双链表
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add("aa");
        linkedHashSet.add("ab");
        linkedHashSet.add(9);
        linkedHashSet.add(null);

        for (Object o : linkedHashSet) {
            System.out.println(o);
        }
    }
}
