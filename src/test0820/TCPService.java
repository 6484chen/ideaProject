package test0820;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @ClassName TCPService
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/20 15:37
 * @Version 1.0
 */
public class TCPService {
    public static void main(String[] args) {

        BufferedReader br =null;
        BufferedWriter bw =null;
        //1.创建服务端
        try {
            ServerSocket serverSocket =new ServerSocket(8999);
            System.out.println("等待客户端来连接");
            //2.等待连接
            Socket client = serverSocket.accept();
            //3.进行通信
            OutputStream  outputStream =client.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(outputStream);
            bw = new BufferedWriter(osw);
            Date date =new Date();
            bw.write("hello 客户端，我是王琛,当前时间为："+date);
            bw.flush();
            client.shutdownOutput();
            //4.
            InputStream is = client.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            InputStreamReader isr = new InputStreamReader(bis);
            br = new BufferedReader(isr);
            String str =br.readLine();
            System.out.println("客户端的信息是："+str);

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
