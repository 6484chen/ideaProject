package test0819;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName CountCharFile
 * @Description 统计一个字符在文本中出现的次数，将字符及数字写到Map中
 * @Author 王琛
 * @Date 2019/8/19 20:18
 * @Version 1.0
 */
public class CountCharFile {
    public static void main(String[] args) {
        //创建Map集合
        Map<Character,Integer> map =new HashMap<Character, Integer>();
        BufferedReader bufferedReader =null;
        BufferedWriter bufferedWriter = null;

       //2.读取文本文件
        try {
            FileReader fileReader = new FileReader("F:\\abc\\file1.txt");   //读入的该文件为UTF-8类型
            bufferedReader = new BufferedReader(fileReader);
            int rs = 0;
            while ((rs = bufferedReader.read()) != -1) {
                char ch = (char) rs;
                //2.1 存入map中
                //判断map中是否有该字符
                if (map.get(ch) == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }
            //3.写入文件中
            FileWriter fileWriter = new FileWriter("F:\\abc\\wordcount.txt");
            bufferedWriter = new BufferedWriter(fileWriter);

            //遍历Map
            Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
            for (Map.Entry<Character, Integer> ciEntry : entrySet) {
                switch (ciEntry.getKey()) {
                    case ' ':
                        bufferedWriter.write("空格=" + ciEntry.getValue());
                        break;
                    case '\t':
                        bufferedWriter.write("tab键=" + ciEntry.getValue());
                        break;
                    case '\r':
                        bufferedWriter.write("回车=" + ciEntry.getValue());
                        break;
                    case '\n':
                        bufferedWriter.write("换行=" + ciEntry.getValue());
                        break;
                    default:
                        bufferedWriter.write(ciEntry.getKey() + "=" + ciEntry.getValue());
                        break;

                }
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null)
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(bufferedWriter != null)
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
