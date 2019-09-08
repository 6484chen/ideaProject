package test0814;

public class Student1<T,M> extends Student {
    private T sno1;
    private M sage1;
   //无参构造函数


    public Student1(String sname, Integer age, int sno, String classname, T sno1, M sage1) {
        super(sname, age, sno, classname);
        this.sno1 = sno1;
        this.sage1 = sage1;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "sno1=" + sno1 +
                ", sage1=" + sage1 +
                '}';
    }

    public static void main(String[] args) {
        Student1<String,Integer> student1 = new Student1<String, Integer>("张三",22,23,"ss","2123",232);
        System.out.println(student1);

    }
}
