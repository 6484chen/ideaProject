package test0821;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @ClassName UdpReceive
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/21 10:37
 * @Version 1.0
 */
public class UdpReceive {
    public static void main(String[] args) {
       /* DatagramSocket datagramSocket;

        {
            try {
                datagramSocket = new DatagramSocket(8999);
                byte [] buff = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buff,0,buff.length);
                datagramSocket.receive(dp);
                String str = new String(dp.getData(),0,dp.getLength());
                //String str = new String(buff);

                System.out.println(str);
                datagramSocket.close();
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

       new Thread(new mesageThread()).start();

    }

}

class mesageThread implements Runnable{
    private DatagramSocket datagramSocket;

    public mesageThread() {
        try {
            this.datagramSocket = new DatagramSocket(8999);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        byte [] buff = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buff,0,buff.length);
        while(true){
            try {
                datagramSocket.receive(dp);  //?思考
                //若果收到的数据长度不一样？
                String str = new String(dp.getData(),0,dp.getLength());
                System.out.println(str+">>"+dp.getAddress());
                datagramSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}