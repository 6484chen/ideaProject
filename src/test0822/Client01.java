package test0822;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName Client01
 * @Description 用户1
 * @Author 王琛
 * @Date 2019/8/24 9:44
 * @Version 1.0
 */
public class Client01 {
    private ChessBorad chessBorad;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class clazz = GogangGame.class;
        GogangGame gogangGame = (GogangGame) clazz.newInstance();
        try {
            Socket socket = new Socket("127.0.0.1",8999);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                String str = br.readLine();
                System.out.println(str);
                String[] array = str.split(" ");
                for (int i = 0; i < ChessBorad.BoradSize; i++) {
                    for (int j = 0; j < ChessBorad.BoradSize; j++) {
                        System.out.print(array[i * ChessBorad.BoradSize + j]);
                    }
                    System.out.println();
                }
                System.out.println(array[array.length - 1]);

                //System.out.println("请下棋。。。");
                Scanner scanner = new Scanner(System.in);
                String s = scanner.nextLine();
                bw.write(s);
                bw.flush();
                socket.shutdownOutput();
                if(false){
                    break;
                }

            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
