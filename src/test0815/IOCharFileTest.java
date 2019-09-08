package test0815;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOCharFileTest {
    public static void main(String[] args) throws IOException {
        //打开字符输入流
        FileReader fileReader =new FileReader("F:\\aaa\\dir3\\dir4\\20190815_144848.jpg");
        //打开字符输出流
        FileWriter fileWriter = new FileWriter("F:\\aaa\\tests.txt");
        int rs = -1;
        char [] c = new char[1024];
        int count=0;
        long start=System.currentTimeMillis();
        while ((rs = fileReader.read(c))!=0){
            if(rs == -1){
                break;
            }
            fileWriter.write(c,0,rs);
            count++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println(count);
        //关闭写入字符流
        fileWriter.close();
        //关闭读入字符流
        fileReader.close();
    }

}
