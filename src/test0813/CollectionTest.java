package test0813;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionTest {
    public static void main(String[] args) {
        //1.collection接口
        Collection col = new ArrayList();
        col.add("aaa");
        col.add("bbb");
        System.out.println("col.size:  "+col.size());
        System.out.println( "col.isEmpty:  " +col.isEmpty());
        Iterator iterator = col.iterator();
        for (int i = 0; i < col.size(); i++) {
            System.out.println(iterator.next());
            iterator.hasNext();

        }
    }
}
