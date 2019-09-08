package test0820;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TCPServer2
 * @Description 多用户访问模式
 * @Author 王琛
 * @Date 2019/8/20 16:32
 * @Version 1.0
 */
public class TCPServer2 {
    public static void main(String[] args) {
        ServerSocket ss;
        Map<String,Socket> map = new HashMap<>();

            try {
                ss = new ServerSocket(9999);
                System.out.println("服务器正在启动中......");
                while (true){
                    Socket client =ss.accept();

                    System.out.println(client.getRemoteSocketAddress().toString());
                    map.put(client.getRemoteSocketAddress().toString(),client);
                    //调用线程
                    new Thread(new ExTherad(client,map));
                    //返回信息
                    SendMsgToClient(map);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


    }
    /*
    *@author 王琛
    *@Description  为每个用户反馈信息
    *@Date 17:00 2019/8/20
    *@Param [clientMap]
    *@Return void
    **/
    public static void SendMsgToClient(Map<String,Socket> clientMap){
        for (Socket socket : clientMap.values()) {
            System.out.println(socket.getRemoteSocketAddress().toString());
            try {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(socket.getOutputStream())));
                bw.write("当前的人数为："+clientMap.size());
                bw.flush();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

class ExTherad implements Runnable{
    private Socket s;
    private InputStream is;
    private Map<String,Socket> map;

    public ExTherad(Socket s, Map<String, Socket> map) {
        this.s = s;
        this.map = map;
    }

    public void run(){
        try {
            while (true){
                //线程获取输入流
                //is = s.getInputStream();    //处理字节流
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));  //这是处理字符文件


            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
