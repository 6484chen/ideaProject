package test0819;

import java.io.*;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/19 11:12
 * @Version 1.0
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\abc\\file1.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int sum = 0;

        String line;
        while ( (line = bufferedReader.readLine())!= null){
            char [] arr = new char[line.length()];
            arr = line.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == 'A' || arr[i] == 'a')
                    sum++;
            }

        }
        System.out.println("A和a的字数为"+sum);
        bufferedReader.close();
        fileReader.close();
        //FileInputStream fileInputStream = new FileInputStream();
    }


}
