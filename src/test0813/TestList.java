package test0813;

public class TestList {
    public static void main(String[] args) {
        StudentList stu = new StudentList("123451","张三","10001");
        StudentList stu1 = new StudentList("123452","张三","10001");
        StudentList stu2 = new StudentList("123453","张三","10001");
        StudentList stu3 = new StudentList("123454","张三","10001");
        StudentList stu4 = new StudentList("123455","张三","10001");
        StudentList stu5 = new StudentList("123456","张三","10001");
        EatList eatList = new EatList();

        eatList.addList(stu);
        eatList.addList(stu1);
        eatList.addList(stu2);
        eatList.addList(stu3);
        eatList.addList(stu4);
        eatList.addList(stu5);

        eatList.listPrint();

        eatList.leaveList();
        StudentList stu6 = new StudentList("123457","张三","10001");
        eatList.listPrint();

        for (int i = 0; i < 10; i++) {
            StudentList stut = new StudentList("12345"+i,"张三","10001");
            if(eatList.addList(stut) == false){
                System.out.println("未入队列的是："+stut.getSnu());
            }

        }

    }
}
