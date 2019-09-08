package test0815;

import java.io.*;

/**
 * @ClassName PrintStreamTEst
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/19 9:31
 * @Version 1.0
 */
public class PrintStreamTEst {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //对象徐磊话
        Student student =new Student("张三","男","123465");
        FileOutputStream fileOutputStream =new FileOutputStream("F:\\abc\\def\\Object.dat");  //文件输出流
        //对象序列化不安全
        ObjectOutputStream objectOutputStream =new ObjectOutputStream(fileOutputStream);   //序列化
        objectOutputStream.writeObject(student);
        objectOutputStream.write(22);
        objectOutputStream.close();

        //反序列化
        FileInputStream fileInputStream = new FileInputStream("F:\\abc\\def\\Object.dat");  //加入文件输入流
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        objectInputStream.readObject();
        int read = objectInputStream.read();
        fileInputStream.close();
        objectInputStream.close();
        System.out.println();
        System.out.println(read);


    }
    /*
     *@author 王琛
     *@Description  字节、字符打印流
     *@Date 9:40 2019/8/19
     *@Param [args]
     *@Return void
     **/
    public void byteAndCharPrintStream() throws FileNotFoundException {
        File file = new File("F:\\abc\\def\\test1.out");
        PrintStream printStream = new PrintStream(file);   //写入到文件中
        printStream.println("hello");
        printStream.println(true);
        printStream.flush();  //刷新文件
        printStream.close();

        //TODO:怎么解决打印不覆盖;
        PrintWriter printWriter = new PrintWriter(file);  //
        printWriter.println(3424);
        printWriter.print("name write");
        printWriter.print(22.33);
        printWriter.flush();
        printWriter.close();
    }

    /*
     *@author 王琛
     *@Description   数据写入流,主要对基本的数据流进行操作，不是字符
     *               要求读取顺序和写入顺序一样
     *@Date 9:49 2019/8/19
     *@Param [args]
     *@Return void
     **/
    public void dataStream() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\abc\\def\\test1.dat");
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        dataOutputStream.write(22);
        dataOutputStream.writeUTF("name");
        dataOutputStream.writeDouble(22.2);
        dataOutputStream.flush();

        FileInputStream fileInputStream = new FileInputStream("F:\\abc\\def\\test1.dat");
        DataInputStream dataInputStream =new DataInputStream(fileInputStream);
        int a = dataInputStream.read();
        String s = dataInputStream.readUTF();
        double d = dataInputStream.readDouble();
        System.out.println(a+s+d);

        dataOutputStream.close();
        dataInputStream.close();
        fileInputStream.close();
        fileOutputStream.close();

    }
    }
