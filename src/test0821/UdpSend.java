package test0821;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @ClassName UdpSend
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/21 10:29
 * @Version 1.0
 */
public class UdpSend {
    public static void main(String[] args) {
        /*try {
            //1。创建数据报连接
            DatagramSocket datagramSocket = new DatagramSocket();
            //2.创建数据报的大小
            byte[] buff = new byte[1024];
            //3.输入写入的内容
            buff = "hello".getBytes();
            //4.创建数据报包
            DatagramPacket dp = null;
            dp = new DatagramPacket(buff, 0, buff.length, InetAddress.getByName("127.0.0.1"), 8999);
            //5.发送数据
            datagramSocket.send(dp);
            //6.关闭数据报连接
            datagramSocket.close();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }catch (SocketException e) {
            e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
*/
        new Thread(new sendMesage("127.0.0.1",8999)).start();

    }
}

class sendMesage implements Runnable{
    private DatagramSocket datagramSocket;
    private String ipAddress;  //ip地址
    private int port;   //端口号

    public sendMesage(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
        try {
            this.datagramSocket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入发送的消息");
            String msg= sc.nextLine();
            byte[] buff = msg.getBytes();
            DatagramPacket dp  = null;
            try {
                dp = new DatagramPacket(buff,0,buff.length, InetAddress.getByName(ipAddress),port);
                datagramSocket.send(dp);
                datagramSocket.close();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}