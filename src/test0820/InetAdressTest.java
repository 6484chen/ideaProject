package test0820;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName InetAdressTest
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/20 14:59
 * @Version 1.0
 */
public class InetAdressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress =InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress()); //获取域名IP地址

        InetAddress inetAddress1 =InetAddress.getLocalHost();  //获取本地的ip和主机名
        System.out.println(inetAddress1);

        System.out.println(inetAddress.getCanonicalHostName()); //
        System.out.println(inetAddress1.isLinkLocalAddress());
        System.out.println(inetAddress1.getLoopbackAddress());  //获取回环地址和域名
        try {
            System.out.println(inetAddress1.isReachable(6000));  //获取回环地址和域名
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
