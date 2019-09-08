package test0814;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
    public static void main(String[] args) throws IOException {
        /*File dir1 = new File("F:\\aaa");
        if(!dir1.exists()){
            dir1.mkdir();
        }
        File dir2 = new File(dir1,"dir2");  //创建以dir1为父目录，名为dir2的对象
        if(!dir2.exists()){
            dir2.mkdir();
        }

        File dir4 = new File(dir1,"dir3\\dir4");
        if(!dir4.exists()){
            dir4.mkdirs();
        }
        //创建文件
        File file = new File(dir1,"tests.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        //查看文件大小
        System.out.println("文件大小："+dir1.length());

        //重命名文件
        file.renameTo(new File(dir1,"hello.txt"));   //dir1是文件的父目录，file是当前文件，new是使用的创建文件方法

        System.out.println("获取绝对路径文件："+file.getAbsoluteFile());
        System.out.println("获取绝对路径："+file.getAbsolutePath());
        System.out.println("获取文件名"+file.getName());
        System.out.println("获取父目录"+file.getParent());*/
        //System.out.println("删除标志"+file.delete());
        //递归打印F盘的所有文件
       /* File file1 = new File("F:\\");
        FileTest fileTest = new FileTest();
        fileTest.printAllFile(file1);*/
        Date date =new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateStr = simpleDateFormat.format(date);
       File dir = new File("F:\\aaa\\dateStr");
       if(!dir.exists()){
           dir.mkdir(); //创建目录
       }
        int UUID = (int)(Math.random()*(100000-1)+1);
        String UUID1 = String.valueOf(UUID);
        File file2 = new File(dir,UUID1);
        if(!file2.exists()) {
            file2.createNewFile();
        }


    }

    public void printAllFile(File path) {
        File[] files = path.listFiles();
        if(files == null || files.length == 0)
            return;
        for (File file : files) {
            if(file.isFile()){
                file.getAbsolutePath();
                System.out.println(file.getName());
            }else{
                printAllFile(file);
            }
        }
    }
}
