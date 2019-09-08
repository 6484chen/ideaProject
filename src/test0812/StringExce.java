package test0812;

public class StringExce {
    public static void main(String[] args) {
        System.out.println(stringTrim(" abc "));
        System.out.println(reverseString("abcdef",2,4));
    }
    //自定义trim函数
    public static String stringTrim(String str){
        if(str == null){
            return null;
        }
        int start = 0;
        int end = str.length()-1;

        //2.从开始寻找空格
        while (start<end&&str.charAt(start)==' '){
            start++;
        }
        while (start<end&&str.charAt(end)==' '){
            end--;
        }
        return str.substring(start,end+1);
    }
    //反转指定字符串
    public static String reverseString(String str,int start,int end){
        //String newString = str.substring(start,end);
        char [] newChar = str.toCharArray();
        char temp = ' ';
        for (int i=start,j=end; i < j; i++,j--) {
            //交换字符
            temp = newChar[i];
            newChar[i] = newChar[j];
            newChar[j] = temp;
        }
        String str1 = new String(newChar);
        return str1;

    }
    //获取一个字符在另一个字符中出现的次数
    public static int stringCount(String str1,String str2){
        String max = str1.length() > str2.length()?str1 : str2;
        String min = str1.length() < str2.length()?str1 : str2;
        //1.定义字符串的计数器
        int count = 0;
        int index = 0;
        while (index<str1.length())
            //2.获取字符串在目标字符串中的起始位置
            index = str1.indexOf(str2);
            //3.接着从下次起始目标位置开始计算，次数加一
            count++;
            index = index + str2.length();
        return count;

    }
}
