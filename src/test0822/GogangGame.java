package test0822;

import java.io.*;
import java.util.Scanner;

/**
 * @ClassName GogangGame
 * @Description 进行游戏
 * @Author 王琛
 * @Date 2019/8/22 10:01
 * @Version 1.0
 */
public class GogangGame {

    public  ChessBorad chessBorad;
    private int posx = 0 ;
    private int posy = 0 ;
    private int WIN_COUNT = 5;
    private boolean play = true;
    //加载棋盘
    public GogangGame(){
        this.chessBorad = new ChessBorad();
    }

    //游戏棋盘的传递
    public GogangGame(ChessBorad chessBorad){
        this.chessBorad = chessBorad ;
    }


    //判断用户的输入合法性  ,
    public boolean isValid(String str){  // 还没输入棋子颜色

        //判断是否暂停游戏
        if (str.equals("pause")){
           pause();
           return false;
       }
        //判断是否继续游戏
        if(str.equals("replay")){
            isReplay();
            return true;
        }

        String [] pos = str.split(",");
        this.posx = Integer.parseInt(pos[0])-1;
        this.posy = Integer.parseInt(pos[1])-1;
        //判断输入是否有效
        if(posx < 0 || posx > 15 || posy <0 || posy > 15) {
            //System.out.println("输入的横坐标不合法");
            return false;
        }

        //判断位置是否有效
        if(!(chessBorad.getBoard()[posx][posy].equals("╬"))){
            return false;
        }
        return true;
    }

    /*
    *@author 王琛
    *@Description  游戏开始
    *@Date 9:36 2019/8/24
    *@Param []
    *@Return void
    **/
    public void start(){
        //初始化棋盘
        chessBorad.initChessBorad();
        chessBorad.printChessBorad();
        //下棋子

        Scanner sc = new Scanner(System.in);

        String str = null;
        while (true){
            System.out.println("请输入下棋的位置,格式为 (x,y):");
            if(!isValid(str = sc.nextLine())){
                System.out.println("输入位置不合法，请重新输入");
                continue;
            }

            //设置棋子
            if(play) {
                this.chessBorad.setBoard(posx, posy, ChessMan.BLACK);
                play = false;
            }else {
                this.chessBorad.setBoard(posx, posy, ChessMan.WHITE);
                play = true;
            }
            this.chessBorad.getBoard();
            chessBorad.printChessBorad();
            //判断输赢
            this.isWon(posx,posy,ChessMan.BLACK);
            //
        }
    }



    //判断输赢
    public boolean isWon(int posx,int posy,String ico){ //ico为棋子类型
        int startPosx = 0;
        int startPosy = 0;
        int endPosx =ChessBorad.BoradSize-1;
        int endPosy =ChessBorad.BoradSize-1;
        int temp = 0 ;
        int tempx = 0 ;
        int tempy = 0 ;

        temp = posx - WIN_COUNT + 1;
        startPosx  = temp > 0 ? temp : 0;

        temp = posy - WIN_COUNT + 1;
        startPosy  = temp > 0 ? temp : 0;

        temp = posx + WIN_COUNT -1;
        endPosx = temp < ChessBorad.BoradSize  ? temp : ChessBorad.BoradSize - 1 ;

        temp = posy + WIN_COUNT -1;
        endPosy = temp < ChessBorad.BoradSize ? temp : ChessBorad.BoradSize - 1  ;


        System.out.println("1 ->>  ("+startPosx+","+startPosy+"),("+endPosx+","+endPosy+")");

        int count = 0 ;
        //纵向判断
        String[][] board = chessBorad.getBoard();
        for (int i = startPosx; i < endPosx; i++) {

            if( board[i][posy] == ico && board[ i+1][posy]==ico){
                count++;
            }else if(count != 4){
                count = 0 ;
            }
            if(count == 4){
                gameOver();
                break;
            }
        }
        //横向判断
        for (int i = startPosy; i < endPosy; i++) {
            if( board[posx][i] == ico && board[posx][i+1]==ico){
                count++;
            }else if(count != 4){
                count = 0 ;
            }
            if(count == 4){
                gameOver();
                break;
            }

        }

        //左上到右下
        if(count ==0) {
            int startPosy1 = 0;
            int startPosx1 = 0;
            if(posx < posy) {
                startPosy1 = posx - (WIN_COUNT - 1) < 0 ? startPosy + Math.abs(posy - posx) : startPosy;
                startPosx1 = posy - (WIN_COUNT - 1) < 0 ? 0 : startPosx;
            }else {
                startPosx1 = posy - (WIN_COUNT - 1) < 0 ? startPosx + Math.abs(posy - posx) : startPosx;
                startPosy1 = posx - (WIN_COUNT - 1) < 0 ? 0 : startPosy;
            }
            System.out.println("2 ->> ("+startPosx1+","+startPosy1+"),("+endPosx+","+endPosy+")");
            for (int i = startPosx1,j = startPosy1; i <= endPosx && j <= endPosy; i++,j++) {
                if (board[i][j] == ico) {
                    count++;
                } else if (count != 5) {
                    count = 0;
                }
                if (count == 5) {
                    gameOver();
                    break;
                }
            }
        }

        //右上到左下
        if (count==0){
            int startPosx1 = 0;
            int endPosy1 = 0;
            if(posx + posy > 14){
                startPosx1 = (posy+WIN_COUNT ) > ChessBorad.BoradSize ? startPosx+(posy + WIN_COUNT )-ChessBorad.BoradSize  : startPosx ;
                endPosy1 = (posx - WIN_COUNT +1) < 0 ? endPosy +(posx - WIN_COUNT +1) : endPosy;
                //endPosy1 = (posx - WIN_COUNT +1) < 0 ? endPosy +(posx - WIN_COUNT +1) : endPosy;
            }else {
                startPosx1 = (posx - WIN_COUNT + 1) < 0 ? 0: startPosx ;
                endPosy1 = posx < WIN_COUNT ? posy + posx : endPosy;
            }
            System.out.println("3 ->> ("+startPosx1+","+startPosy+"),("+endPosx+","+endPosy1+")");
            for (int i = startPosx1 ,j = endPosy1; i <= endPosx && j >= startPosy ; i++,j--) {
                if (i == endPosy) {
                    count++;
                }
                if (board[i][j] == ico) {
                    count++;
                } else if (count != 5) {
                    count = 0;
                }
                if (count == 5) {
                    gameOver();
                    break;
                }
            }
        }


        return false;
    }


    //重新开始，返回上一局
    public boolean isReplay(){
        int count = 0;
        int sum;
        File file = new File("E:\\huadi\\ideaProject\\src\\test0822\\pauseGame");
        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = br.readLine();
            String[] array = str.split(" ");
            sum = Integer.parseInt(array[2]);
            String sparseArray[][] = new String[sum+1][3];
            System.out.println(array.length);
            for (int i = 0; i < array.length; i=i+3){
                sparseArray[count][0] = array[i];
                sparseArray[count][1] = array[i+1];
                sparseArray[count][2] = array[i+2];
                count++;

            }


            //写入棋盘
            for (int i = 1; i <= sum; i++) {

                chessBorad.setBoard(Integer.parseInt(sparseArray[i][0]) ,Integer.parseInt(sparseArray[i][1]),sparseArray[i][2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {


        }


        return false;
    }

    //计算机下棋
    public int[][] computerDo(){
        int [][] computer = new int[5][5];
        return computer;
    }

    //游戏暂停,把游戏存档
    public void pause(){
        //使用稀疏数组进行存储，减少空间占用
        int sum = 0;
        String [][] array = chessBorad.getBoard();
        for (int i = 0; i < ChessBorad.BoradSize; i++) {
            for (int j = 0; j < ChessBorad.BoradSize; j++) {
                if(array[i][j]!="╬"){
                    sum++;
                }
            }
        }

        //创建稀疏数组，并且赋值
        String  [][] sparseArray =new String[sum+1][3];
        sparseArray[0][0] = String.valueOf(ChessBorad.BoradSize);
        sparseArray[0][1] = String.valueOf(ChessBorad.BoradSize);
        sparseArray[0][2] = String.valueOf(sum);
        int count = 0;
        for (int i = 0; i < ChessBorad.BoradSize; i++) {
            for (int j = 0; j < ChessBorad.BoradSize; j++) {
                if(array[i][j]!="╬"){
                    count++;
                    sparseArray[count][0]= String.valueOf(i);
                    sparseArray[count][1]= String.valueOf(j);
                    sparseArray[count][2]=array[i][j];
                }
            }
        }

        File file = new File("E:\\huadi\\ideaProject\\src\\test0822\\pauseGame");
        try {
            BufferedWriter  bw = new BufferedWriter(new FileWriter(file));
            //BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            for (int i = 0; i <= Integer.parseInt(sparseArray[0][2]); i++) {
                for (int j = 0; j < 3; j++) {
                    bw.write(sparseArray[i][j]+" ");
                }
            }
            bw.flush();
            System.out.println("游戏暂停！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean gameOver(){
        System.out.println("*******   game over  ******");
        chessBorad.initChessBorad();
        return true;
    }



    /*
        从右上到左下，乱序也会错误
     */
    public static void main(String[] args) {
        GogangGame go = new GogangGame();
            go.start();


    }
}
