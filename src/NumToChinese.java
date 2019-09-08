import java.util.Scanner;

public class NumToChinese {

    public static void main(String[] args) {
        String [] bigNumber= {"零","壹","贰","叁","肆","伍","陆","柒","扒","玖"};
        String [] units={"","拾","佰","仟","万","亿"};  //单位
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        String value = input.next();
        //int num=505;    //待处理这种情况
        int num =(int) Integer.valueOf(value);
        int k = Integer.toString(num).length();

        System.out.println(num);
        String chineseNumber="";   //存放大写中文数字结果
        int count=0;   //统计0的个数
        if(num<0){
            chineseNumber+="负";
            num=-num;
        }
        else {
            for (int i = 4; i > 0; i--) {

                int n = num / (int) Math.pow(10, i);
                if (n != 0) {
                    if (count > 0) {   //处理读取数字之间的零
                        chineseNumber += bigNumber[0];
                        count = 0;
                    }
                    chineseNumber += bigNumber[n] + units[i];
                }
                count++;
                num = num % (int) Math.pow(10, i);
            }
            //处理个位的读取与舍去
            if (num != 0) {
                if (count > 0) {
                    chineseNumber += bigNumber[0];
                    count = 0;
                }
                chineseNumber += bigNumber[num];
            }

        }

        System.out.println(chineseNumber);
    }


}
