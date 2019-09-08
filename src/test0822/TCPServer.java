package test0822;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName TCPServer
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/24 10:08
 * @Version 1.0
 */
public class TCPServer {
    public static void main(String[] args) {
        File file = new File("E:\\huadi\\ideaProject\\src\\test0822\\pauseGame");
        ServerSocket serverSocket;

        {
            try {
                serverSocket = new ServerSocket(8999);
                System.out.println("服务器正在启动。。。。");

                BufferedReader brf = new BufferedReader(new FileReader(file));
                BufferedWriter bwf = new BufferedWriter(new FileWriter(file));
                GogangGame gogangGame = new GogangGame();

                int count= 0;
                //用户服务器交互
                Socket client = serverSocket.accept();
                while (true){
                    BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                    gogangGame.start();
                    gogangGame.pause();
                    String str = brf.readLine();
                    System.out.println("服务器向客户端发送。。。");
                    bw.write(str);
                    bw.write("请开始下棋：格式为（x,y）");
                    bw.flush();
                    client.shutdownOutput();
                    System.out.println("写入");

                    String cInput= br.readLine();
                    if(!gogangGame.isValid(cInput)){
                        bw.write("请开始下棋：格式为（x,y）");
                        bw.flush();
                        client.shutdownOutput();
                        continue;
                    }

                    //设置棋子
                    String [] pos = cInput.split(",");
                    int posx = Integer.parseInt(pos[0])-1;
                    int posy = Integer.parseInt(pos[1])-1;
                    int i = count % 2;
                    System.out.println(pos.toString()+"  i  " + i);
                    if(i == 0 ) {
                        gogangGame.chessBorad.setBoard(posx, posy, ChessMan.BLACK);
                        gogangGame.chessBorad.getBoard();
                        gogangGame.chessBorad.printChessBorad();
                        //判断输赢
                        if(gogangGame.isWon(posx,posy,ChessMan.BLACK)) {
                            break;
                        }
                    }else {
                        gogangGame.chessBorad.setBoard(posx, posy, ChessMan.WHITE);
                        gogangGame.chessBorad.getBoard();
                        gogangGame.chessBorad.printChessBorad();
                        //判断输赢
                        if(gogangGame.isWon(posx,posy,ChessMan.WHITE)) {
                            break;
                        }

                    }

                }
                client.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
