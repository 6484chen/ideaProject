package test0816;

public class Girl {
    private String name;
    private int age;

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void marry(Boy boy){
        System.out.println("我想嫁给"+boy.getName());
    }
    //对象比较大小
    public int compare(Girl girl){
        return this.age- girl.age;  //如果是负数，代表当前对象小，大于0则表示当前对象大
    }
}
