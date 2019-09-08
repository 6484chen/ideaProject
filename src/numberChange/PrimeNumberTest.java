package numberChange;

//输出100以内的指数
public class PrimeNumberTest {
    public static void main(String[] args) {
        int count = 0;
        long start = System.currentTimeMillis();

        for (int i = 2; i < 100; i++) {  //从2到100进行遍力
            boolean flag = true;   //设置标志
            //for (int j = 2; j < i; j++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0){  //如果被除尽说明最大公因子不是1和它本身
                    flag = false;
                    break;    //优化1
                }

            }
            if(flag == true) {
                System.out.println(i);
                count++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(count);
        System.out.println(end-start);  //291, 优化一：63  优化二：48
        System.out.println("***********************************");
        //printTest();
    }

}
