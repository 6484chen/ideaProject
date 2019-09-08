package test0814;

public class Student extends Man {
    private int sno;
    private String classname;
    //重写构造函数
    /*public Student(Integer sname, String age, int sno, String classname) {
        super(sname, age);
        this.sno = sno;
        this.classname = classname;
    }*/

    public Student(String sname, Integer age, int sno, String classname) {
        super(sname, age);
        this.sno = sno;
        this.classname = classname;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

}
