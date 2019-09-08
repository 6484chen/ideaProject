package test0815;

import java.io.*;

/**
 * @ClassName IOTFile
 * @Description 数据拷贝
 * @Author 王琛
 * @Date 2019/8/19 17:48
 * @Version 1.0
 */
public class IOTFile {
    public static void main(String[] args)  {
        IOTFile iotFile = new IOTFile();
        iotFile.copyFile("F:\\abc\\file1.txt","F:\\abc\\file2.txt");

    }
    /*
    *@author 王琛
    *@Description  使用字节流拷贝文件
    *@Date 19:50 2019/8/19
    *@Param [srcPath, desPath]
    *@Return void
    **/
    public void copyFile(String srcPath,String desPath){
        //1.创建File类对象
        File srcFile = new File(srcPath);  //源文件
        File desFile = new File(desPath);  //目标路径文件

        //2.创建输入输出的节点流
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {

            fileInputStream =new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(desFile);
            //2.2 创建缓冲流，处理节点流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            //3.执行读取、写入操作
            byte [] buff = new byte[1024];  //一次读取的大小
            int len;  //读取的长度
            while ((len = bufferedInputStream.read(buff))!= -1){
                //加密操作
                for (int i = 0; i < len; i++) {
                    buff[i] = (byte) (buff[i]^5);
                }
                bufferedOutputStream.write(buff,0,len);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            //4.关闭流，要求先关闭外层，在关闭内层。但是系统在关闭外层时，会默认关闭内层。
            if(bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedOutputStream != null){
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
