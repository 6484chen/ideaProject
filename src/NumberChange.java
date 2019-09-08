public class NumberChange {
     String [] bigNumber= {"零","壹","贰","叁","肆","伍","陆","柒","扒","玖"};
     static String [] units={"","拾","佰","仟","万","亿"};  //单位
     static int [] smallNumber = new int[5];
     //static String [] bigNumber1 = new String[5];
    static String [] bigNumber1 = {"","","","",""};

    //对数字进行切分
    public static void modle1(int value){
        int k = Integer.toString(value).length();
        int a =value%10;
        int b = value/10;
        smallNumber[0]=a;
        for (int i = 1; i <k ; i++) {
                a = b % 10;
                b = b / 10;
                smallNumber[i] = a;
        }


        for (int i = 0; i <smallNumber.length ; i++) {
            System.out.print(smallNumber[i]+" ");
        }
    }

    //数字对应的方法
    public static void match(){
        String a="";
        int count=0;
        for (int i = smallNumber.length-1; i >= 0; i--) {
            switch (smallNumber[i]){
                case 0:{a="零";break;}
                case 1:{a="壹";break;}
                case 2:{a="贰";break;}
                case 3:{a="叁";break;}
                case 4:{a="肆";break;}
                case 5:{a="伍";break;}
                case 6:{a="陆";break;}
                case 7:{a="柒";break;}
                case 8:{a="扒";break;}
                case 9:{a="玖";break;}
            }
           //存入字符数组
            if(i!=0) {
                if (a == "零" && count > 0) {   //处理多余的零
                    count++;
                    continue;
                } else if (a == "零") {
                    bigNumber1[smallNumber.length - 1 - i] = a;
                    count++;
                } else {

                    bigNumber1[smallNumber.length - 1 - i] = a + units[i];
                    count = 0;
                }
            }else {
                bigNumber1[smallNumber.length - 1 - i] = a + units[i];
            }

        }
        for (int i = 0; i <5 ; i++) {
            System.out.print(bigNumber1[i]);
        }
    }


    public static void main(String[] args) {
        int num=10020;
        modle1(num);
        match();


    }
}
