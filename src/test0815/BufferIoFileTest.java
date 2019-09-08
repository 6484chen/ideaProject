package test0815;

import java.io.*;

public class BufferIoFileTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("F:\\aaa\\hello.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);//减少与硬盘的次数，处理流
        byte [] b1 = new byte[1024];  //一次读取的字节数
        int len = -1;
        while (true){
            try {
                if (!((len=bufferedInputStream.read(b1))!= -1))
                    break;
                System.out.println(new String(b1,0,len));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        bufferedInputStream.close();
        fileInputStream.close();

        //字节写入
        FileOutputStream fileOutputStream =new FileOutputStream("F:\\aaa\\hello.txt");
        BufferedOutputStream bufferedOutputStream =new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write("hello world".getBytes());
        bufferedOutputStream.close();

    }

}
