package test0815;

import java.io.Serializable;

/**
 * @ClassName Student
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/19 10:24
 * @Version 1.0
 */
public class Student implements Serializable {
    //该接口为空，只是为了标识
    private static  final  long varSerialUID = 123;
    public String name;
    public String sex;
    public transient String passwd;  //该元素不被序列化

    public Student(String name, String sex, String passwd) {
        this.name = name;
        this.sex = sex;
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
