package test0822;

/**
 * @ClassName ThreadGame
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/26 19:29
 * @Version 1.0
 */
public class ThreadGame implements Runnable{

    private TCPServer tcpServer;

    public ThreadGame(TCPServer tcpServer){
        this.tcpServer = tcpServer;
    }

    @Override
    public void run() {

    }
}
