package test0816;

public class Boy {

    private String name;
    private int age;

    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void marry(Girl girl){
        System.out.println("我想娶"+girl.getName());
    }
    public  void shout(){
        if (age < 22) {
            System.out.println("先谈谈恋爱~~");
        }else{
            System.out.println("可以结婚了");
        }
    }
}
