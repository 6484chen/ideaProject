package test0819;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @ClassName test02
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/19 11:32
 * @Version 1.0
 */
public class test02 {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\abc\\file1.txt");
        //FileInputStream fileInputStream = new FileInputStream(file);
        //FileReader fileReader =new FileReader(file);
        //BufferedReader bufferedReader =new BufferedReader(fileReader);
        RandomAccessFile randomAccessFile =new RandomAccessFile(file,"r");  //随机读写
        int  point = (int)randomAccessFile.length();
        System.out.println("文件长度："+point);
        byte []b = new byte[10];
        randomAccessFile.seek(point);

        for (int i = point; i > -1; i--) {
            if(randomAccessFile.read(b,i-9,10)>0){
                String str = new String(b);
                System.out.println(b);
            }

        }


        randomAccessFile.close();

    }
}
