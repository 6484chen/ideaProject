public class TestStudent {
    private String name;
    private String sex;
    private int age;
    private String sno;

    public TestStudent(String name){
        this.name=name;
    }

    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null) return false;
        if(o instanceof TestStudent){
            TestStudent t = (TestStudent) o;
            /**
             *
             */
            return true;
        }else
            return false;

    }
    public void printinfo(){
        System.out.println("TestStudent{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", sno='" + sno + '\'');
    }




    public static void main(String[] args) {
        TestStudent t1 = new TestStudent("zhangsan");
        TestStudent t2 = new TestStudent("zhangsan");
        if(t1.equals(t2)){
            System.out.println("true");
        }
    }
}
