package test0818;

import java.io.*;

/**
 * @ClassName IOThread
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/19 16:17
 * @Version 1.0
 */
public class IOThread {
    public static void main(String[] args) throws InterruptedException {
        FileThread fileThread =new FileThread();
        Thread thread = new Thread(fileThread);
        thread.start();
        //thread.join();
        System.out.println("拷贝结束");
    }

}
class FileThread implements Runnable{

    @Override
    public void run() {
        File file =new File("F:\\jdk\\jdk-8u211-windows-x64.exe");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream =new BufferedInputStream(fileInputStream);
            FileOutputStream fileOutputStream =new FileOutputStream("F:\\abc\\file2.txt");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            int rs = -1;
            byte [] by = new byte[1024];
            while( (rs = bufferedInputStream.read(by,0, by.length))!= -1){
                fileOutputStream.write(by,0,by.length);
            }
            fileInputStream.close();
            fileOutputStream.close();
            bufferedInputStream.close();
            bufferedOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("线程：");
    }
}
