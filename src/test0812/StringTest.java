package test0812;

public class StringTest {


    public static void main(String[] args) {
       // String str = "abc";
      /*  String str1 = new String("abc");
        System.out.println(str1+str);
        if(str == str1){
            System.out.println("xiang tong");
        }else{
            System.out.println("bu tong");
        }*/
      /*String str1 = "abd";
      String str2 = str + str1;
      String str3 = "abcabd";
      if(str2 == str3){   // == 等号只是比较内存地址是否相同
          System.out.println("aa");
      }
      if(str2.equals(str3)){
          System.out.println("bb");
      }*/
     String str = "C://upload/images/photo.jpg";
      String [] arr = str.split("\\.");   //这里是正则表达式
        System.out.println(arr[1]+" \n"+arr[0]);
        int index = str.lastIndexOf("jpg");
        arr[0] = str.substring(index);
        arr[1] = str.substring(0,index);
        System.out.println(arr[0]+"  "+arr[1]);

       /* String str1 = "我我我爱爱中国";
        char [] arr1 = new  char[str1.length()];
        int count = 0;
        char char1 = ' ';
        for (int i = 0; i <str1.length() ; i++) {
            if(char1 != str1.charAt(i)){

                arr1[count]=str1.charAt(i);
                count++;
                char1 = str1.charAt(i);
            }


        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }*/

        String str2 = "  hello  world  ";
        String str3 = str2.trim();
        System.out.println(str3);
        System.out.println(str2.replace(" ",""));

        String str4 = "我的电话号码是1234564646";
        System.out.println(str4.split("1"));


        String strint = "0032";
        System.out.println();
    }
}
