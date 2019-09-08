package test0815;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class PrimAverage {
    public static double [] db =new double [5];
    public static int count = 0;
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        File path =new File("F:\\aaa\\pima\\pima");
        File[] files = path.listFiles();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        for (File file : files) {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String str1 = null;
            Collection col =new ArrayList();
            while((str1=bufferedReader.readLine())!= null){
                count++;
                String []str = str1.split("\t");  //获取字符串
                String [] arr ;
                arr = Arrays.copyOfRange(str,1,6);   //截取有效数字
                for (int i = 0; i < arr.length; i++) {
                    add(i,Double.valueOf(arr[i]));
                }
            }
        }



        print1();

        bufferedReader.close();
        fileReader.close();
        long end =System.currentTimeMillis();
        System.out.println(end-start);
    }

    public void allFile(File path){
        File[] files = path.listFiles();
        for (File file : files) {
            if(!file.exists()){

            }else{
                allFile(file);
            }
        }
    }
    public static void add(int i,double db1){
        db[i]+=db1;
    }

    public static void print1(){
        for (int i = 0; i < db.length; i++) {
            System.out.println(db[i]/count);
        }
    }

}

