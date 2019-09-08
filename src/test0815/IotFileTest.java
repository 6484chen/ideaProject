package test0815;

import java.io.*;

public class IotFileTest {


    public static void main(String[] args) throws IOException {
        //打开字节输入流
        FileInputStream fileInputStream =new FileInputStream("F:\\abc\\file1.txt");
        //BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);//减少与硬盘的次数，处理流
        //打开字节输出流
        FileOutputStream  fileOutputStream= new FileOutputStream("F:\\aaa\\hello.txt"); //append是可追加的，否则会覆盖
        //BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        //读取并拷贝
        int rs = -1;
        int count=0;  //统计读取的次数
        byte [] b1 = new byte[1024];
        while ((rs = fileInputStream.read(b1))!= -1){

            if(rs == -1){
                break;
            }
            fileOutputStream.write(b1,0,rs);
            count++;
        }

        System.out.println(count);
        //关闭文件写入
        fileOutputStream.close();
        //关闭文件读入
        fileInputStream.close();

    }
}
