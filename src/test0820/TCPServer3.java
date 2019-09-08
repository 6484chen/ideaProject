package test0820;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TCPServer3
 * @Description 客户端和服务端的文件拷贝
 * @Author 王琛
 * @Date 2019/8/20 17:02
 * @Version 1.0
 */
public class TCPServer3 {
    public static void main(String[] args) {
        File file = new File("F:\\abc\\123.png");
        BufferedWriter bufferedWriter = null;
        BufferedReader bufferedReader =null;
        try {
            ServerSocket serverSocket = new ServerSocket(8999);
            System.out.println("等待写入。。。。。");
            Socket client =serverSocket.accept();

            FileInputStream fi =new FileInputStream(file);
            OutputStream os = client.getOutputStream();
            /*bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            bufferedWriter =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            //char[] buff = new char[1024];
            String str = null;
            while ((str=bufferedReader.readLine())!=null){
                bufferedWriter.write(str);
                bufferedWriter.flush();
            }*/

            byte [] buff =new byte[1024];
            int len=0;
            while ((len=fi.read(buff))!=-1) {
                os.write(buff, 0, len);
                os.flush();
            }
            System.out.println("文件接受成功");
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
