package test0826;


import org.junit.*;

public class CalcuateTest {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass");
    }


    @Before
    public void before(){
        System.out.println("beforre");
    }

    @After
    public void after(){
        System.out.println("after");
    }

    @Test
    public void add() {
        Calcuate calcuate = new Calcuate();

        calcuate.add(5,6);
    }
}
