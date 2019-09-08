package test0813;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("Z");
        treeSet.add("W");

        /*
        *添加对象之前需要重写Comparable（）
         */
        treeSet.add(new StudentList("123","zhangsan1","1245"));
        treeSet.add(new StudentList("123","zhangsan1","12456"));
        treeSet.add(new StudentList("123","zhangsan3","1245"));

        for (Object o : treeSet) {
            System.out.println(o);
        }


        /*
        *1.定制排序TreeSet
        * 2.优先使用自顶排序，不需要更改源代码；
         */

        TreeSet treeSet1 = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                StudentList studentList = (StudentList)o1;   //类型转换
                StudentList studentList1 = (StudentList)o2;
                return studentList.getSname().compareTo(studentList1.getSname());
            }
        });
    }
}
