package test0815;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IoFileTest {
    public static void main(String[] args) throws IOException {
        //获得文件路径
        File file =new File("F:\\abc\\def\\20190815\\20190815bf1ff477-81fb-4edb-ba49-8e25128c16e6");
        //创建FileInputStream
        FileInputStream fileInputStream = new FileInputStream(file);
        //2.读取文件
        //fileInputStream.raed()  //返回一个整形 1 和-1，-1 表示读取失败


        int count = 0;  //统计技术的次数
        byte [] b1 = new byte[1024];
        //int rs = -1;
        while (true){//(rs = fileInputStream.read(b1))!= -1
                //int rs = fileInputStream.read();   //如果没有字符则返回负一
            int rs = fileInputStream.read(b1);
             //表示一次读取1024字节
            if(rs== -1){
                break;
            }
            System.out.print(new String(b1,0,rs,"GBK"));
            count++;


        }
        System.out.println(count);
        // 关闭文件
        fileInputStream.close();

    }
}
