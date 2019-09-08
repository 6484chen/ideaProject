package test0815;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File dir = new File("F:\\abc\\def");
        if(!dir.exists()){
            dir.mkdirs();
        }
        File file =new File(dir,"test1.txt");
        if(!file.exists()){
            file.createNewFile();  //编写文件需要抛出异常处理
        }
        File file1 =new File(dir,"test1.txt");
        if(!file1.exists()){
            file1.createNewFile();  //编写文件需要抛出异常处理
        }
        //递归打印所有文件
        printAllFile(dir);


        //

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateDir = simpleDateFormat.format(date);   //获取日期
        File dateMkdir = new File(dir,dateDir);     //日期目录
        String uuid = UUID.randomUUID().toString();  //获取UUID值
        if(!dateMkdir.exists()){
            dateMkdir.mkdir();
        }
        File dateFile =new File(dateMkdir,dateDir+uuid);
        if(!dateFile.exists()){
            dateFile.createNewFile();
        }

    }
    public static void printAllFile(File path){
        if(path ==null || path.length()==0 ){
            return;
        }
        File[] files = path.listFiles();
        for (File file : files) {
            if (file.isFile()){
                System.out.println(file.getAbsoluteFile());
            }else{
                printAllFile(file);
            }
        }

    }
}
