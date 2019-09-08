package test0808;

interface ComparaleEX{
    public int compareTo(Object obj, Object obj1);
}
public class Student implements ComparaleEX{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object obj, Object obj1) {
        return 0;
    }
}
