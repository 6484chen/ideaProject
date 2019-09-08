package test0809;

public class StudentProxy implements StudnetInter {
    Student student ;
    @Override
    public void study() {
        if(student == null){
            student = new Student();
        }
        System.out.println("代理类开始");
        student.study();
        System.out.println("代理类结束");
    }


}
