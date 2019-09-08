public class MethodArgsTest {
    public static void main(String[] args) {
        MethodArgsTest methodArgsTest = new MethodArgsTest();
        methodArgsTest.show(1);
        methodArgsTest.show("aaa");
        //类似参数为数组型
        //methodArgsTest.show("aaa","bbb");  //参数的个数可以改变
        methodArgsTest.show(new String[]{"aa","bb"});
        methodArgsTest.show(new int[]{1,2,3});
        methodArgsTest.show(1,3,3,4);

    }
    public void show(int i){

    }
    public void show(String str){

    }
   /* public void show(String ... str){
        System.out.println("可变个形参个数");
    }*/

    public void show(String [] str){
        System.out.println("可变个形参个数");
    }

    public void show(int ... str){
        System.out.println("可变个形参个数--整形");
    }
}


