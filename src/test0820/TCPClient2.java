package test0820;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName TCPClient2
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/20 17:27
 * @Version 1.0
 */
public class TCPClient2 {
    public static void main(String[] args) {
        String IPAddress = "192.168.148.139";
        BufferedReader bufferedReader =null;
        BufferedWriter bufferedWriter = null;
        File file= new File("F:\\abc\\server");
        //创建Socket，制订服务器地址
        try {
            Socket socket =new Socket(IPAddress,7777);
            //获取输入流
            //获取服务器的消息
            InputStream ip = socket.getInputStream();
            FileOutputStream op = new FileOutputStream(file);
            //bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            //bufferedWriter =new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            /*String str = null;
            while ((str=bufferedReader.readLine())!=null){
                bufferedWriter.write(str);
                bufferedWriter.flush();
            }*/
            byte [] buff =new byte[1024];
            int len=0;
            while ((len=ip.read(buff))!=-1) {
                op.write(buff, 0, len);
                op.flush();
            }
            socket.close();  //关闭连接
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
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
