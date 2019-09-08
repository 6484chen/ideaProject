package test0820;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName TcpClient
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/20 15:30
 * @Version 1.0
 */
public class TcpClient {
    public static void main(String[] args) {
        String IPAddress = "127.0.0.1";
        BufferedReader br =null;
        //创建Socket，制订服务器地址
        try {
            Socket socket =new Socket(IPAddress,9999);
            //获取输入流
            //获取服务器的消息
            InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            InputStreamReader isr = new InputStreamReader(bis);
            br = new BufferedReader(isr);
            String str =br.readLine();
            System.out.println("客户端获取到信息："+str);
            //向服务器发消息
            /*OutputStream outputStream =socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(outputStream);
            BufferedWriter bw = new BufferedWriter(osw);
            Date date = new Date();
            bw.write("hello 我是王琛"+date);
            bw.flush();
            socket.shutdownOutput();*/

            socket.close();  //关闭连接
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
