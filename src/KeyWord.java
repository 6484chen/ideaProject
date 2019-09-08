/**
 * @ClassName KeyWord
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/20 20:53
 * @Version 1.0
 */
public class KeyWord {
    public int id;
    public String name;
    public int age;

    public KeyWord(){
        System.out.println("父类构造器");
    }

    public void printInfo(){
        this.name = "zhangsan";
        this.age = 29;
        this.id = 1;
    }

    public static void main(String[] args) {
        SubKey subKey =new SubKey();
        subKey.printInfo1();       //这行会给父类的id赋值。
        subKey.printInfo();   //交换这两行会出现不同的输出
    }

}

class SubKey extends KeyWord{
    private String sex;
    private int id;

    public SubKey(){
        System.out.println("子类构造器");
    }  //默认调用父类的构造器，super（）；

    public void printInfo1(){
        super.printInfo();
        name = "zhangsan";
        age = 29;
        id = 3;
        sex ="男";
        System.out.println("name:"+name+" ;age:"+age+" ;id:"+id+" ；sex："+sex);
    }

    public void printInfo(){
        name = "zhangsan";
        age = 29;
        id = 3;

        System.out.println("name:"+name+" ;age:"+age+" ;id："+id+" ；id："+super.id);  //获取不到父类的私有属性的值
    }



}
