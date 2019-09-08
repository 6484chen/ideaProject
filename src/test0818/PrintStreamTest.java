package test0818;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @ClassName PrintStreamTest
 * @Description 打印流是将输出的内容，输入到文件中
 *              System.setOut(printStream);
 * @Author 王琛
 * @Date 2019/8/20 10:10
 * @Version 1.0
 */
public class PrintStreamTest {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        PrintStream printStream = null;
        try {
            fileOutputStream = new FileOutputStream("F:\\abc\\file2.txt");

        printStream =new PrintStream(fileOutputStream,true);

        if(printStream != null) {
            System.setOut(printStream);
        }
            for (int i = 0; i < 255; i++) {
                System.out.println((char)i);
                if(i % 50 == 0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printStream.close();


    }
}
