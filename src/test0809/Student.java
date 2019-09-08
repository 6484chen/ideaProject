package test0809;

public class Student implements StudnetInter {
    @Override
    public void study() {
        System.out.println("我正在学习。。。");
    }

    public static void main(String[] args) {
        StudentProxy studentProxy = new StudentProxy();
        studentProxy.study();
    }
}
