package test0826;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName PatternTest
 * @Description 正则表达式
 * @Author 王琛
 * @Date 2019/8/27 9:23
 * @Version 1.0
 */
public class PatternTest {
    public static void main(String[] args) {

        /*
        Pattern 类：
        pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。
        要创建一个 Pattern 对象，你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。该方法接受一个正则表达式作为它的第一个参数。

        Matcher 类：
        Matcher 对象是对输入字符串进行解释和匹配操作的引擎。
        与Pattern 类一样，Matcher 也没有公共构造方法。你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。
         */

        String  pattern = "1[356][5-9][0-9]{8}";
        String line = "15353431311 13534344324 213535343432 1583023858";
        //1.创建pattern编译正则表达式
        Pattern p = Pattern.compile(pattern);

//        Boolean b = Pattern.matches("1[356][5-9][0-9]{8}","15646546846");
//        System.out.println(b);
        //创建matcher对象

        //2.创建matcher对象，匹配字符串
        Matcher m = p.matcher(line);

        while(m.find()){   //捕获组
            System.out.println(m.group());
        }

    }

    @Test
    public void regexTest(){
        /*
        捕获组是把多个字符当一个单独单元进行处理的方法，它通过对括号内的字符分组来创建。

        例如，正则表达式 (dog) 创建了单一分组，组里包含"d"，"o"，和"g"。

        捕获组是通过从左至右计算其开括号来编号。例如，在表达式（（A）（B（C））），有四个这样的组：

        ((A)(B(C)))
        (A)
        (B(C))
        (C)
         */

        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";   //java中对于斜杠需要转义\\

        Pattern p = Pattern.compile(pattern);

        Matcher m = p.matcher(line);

        if(m.find()){
            System.out.println(m.group(0));
            System.out.println(m.group(1));
            System.out.println(m.group(2));
            System.out.println(m.group(3));


        }else {
            System.out.println("bye");
        }


    }



}
