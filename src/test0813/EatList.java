package test0813;

import java.util.LinkedList;

public class EatList {
    private static int listSize = 10;

    LinkedList linkedList = new LinkedList() ;

    public static int getListSize() {
        return listSize;
    }

    public static void setListSize(int listSize) {
        EatList.listSize = listSize;
    }

    //加入队列
    public boolean addList(StudentList stu){
        if(listSize > 0) {
            linkedList.add(stu);
            listSize--;
            System.out.println("进队");
            return true;
        }else{
            return false;
        }

    }
    public  void leaveList(){
        if(linkedList.getFirst() != null) {
            linkedList.removeFirst();
            listSize++;
        }
        System.out.println("出队");
    }
    public void listPrint(){
        if(linkedList.size()>3){
            for (int i = 0; i < 3; i++) {
                System.out.println(linkedList.get(i));
            }
        }else{
            for (Object o : linkedList) {
                System.out.println(o);
            }
        }


    }
}
