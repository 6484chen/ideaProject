package test0808;

/**
 * 一个类只能有一个public class
 */
class FinalClass {
    public final void testPrint() {
        System.out.println("====final Method===");
    }
    public final int COUNT=0;

}

public class FinalTest  extends FinalClass{
    //不能被重写
    /*  public void testPrint(){
        System.out.println("=====aaaa========");
    }*/
}
