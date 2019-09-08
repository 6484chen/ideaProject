package test0819;

import java.io.*;

/**
 * @ClassName ChangeIO
 * @Description 转换流的使用
 * @Author
 * @Date 2019/8/19 21:33
 * @Version 1.0
 */
public class ChangeIO {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("F:\\abc\\file1.txt");
        //字节转换为字符，并且按照UTF-8的格式进行转换
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF8");

        FileOutputStream fileOutputStream = new FileOutputStream("F:\\abc\\charToByte.txt");
        OutputStreamWriter outputStreamWriter =new OutputStreamWriter(fileOutputStream,"GBK");//将字符转换为其他编码

        char [] buff = new char[10];

        int len;

        while ((len = inputStreamReader.read(buff))!= -1){
           // String str = new String(buff,0,len);
            outputStreamWriter.write(buff,0,len);
            //System.out.println(str);
        }




        inputStreamReader.close();

    }
}
