package test0814;

public class Man <T,M>{
    private T sname;
    private M age;

    public T getSname() {
        return sname;
    }

    public void setSname(T sname) {
        this.sname = sname;
    }

    public M getAge() {
        return age;
    }

    public void setAge(M age) {
        this.age = age;
    }

    public Man(T sname, M age) {
        this.sname = sname;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Man{" +
                "sname=" + sname +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
       /* Man man = new Man();
        man.setSname("aaaa");
        man.setAge(123);
        System.out.println(man);
        Man<String,Integer> man1 = new Man<>();
        man1.setSname("张三");
        man1.setAge(234);
        System.out.println(man1);*/
        //Man<String,Integer> man1 = new Man<>("张三",234);
        //System.out.println(man1);
        //实现多态的时候必须与子类继承相同
        /*Man<Integer,String> ma2 = new Student(213,"sas",213,"sss");
        System.out.println(ma2);*/
    }
}
