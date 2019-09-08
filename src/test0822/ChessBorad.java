package test0822;

import org.junit.Test;

/**
 * @ClassName ChessBorad
 * @Description 棋盘类
 * @Date 2019/8/22 9:50
 * @Version 1.0
 */
public class ChessBorad {

    public static final int BoradSize = 15;
    String [][] board = new String [BoradSize][BoradSize];

    //初始化棋盘

    public void initChessBorad(){
        for (int i = 0; i < BoradSize; i++) {
            for (int j = 0; j < BoradSize; j++) {
                board[i][j] = "╬";
            }
        }
    }

    //下棋子
    public void setBoard(Integer posx,Integer posy,String chessMan){
        board[posx.intValue()][posy.intValue()] = chessMan;
    }

    //打印棋盘
    public void printChessBorad(){
        for (int i = 0; i < BoradSize; i++) {
            for (int j = 0; j < BoradSize; j++) {
                System.out.print(board[i][j] );
            }
            System.out.println();
        }
    }

    public String[][] getBoard(){
        return board;
    }

    @Test
    public void test(){
        ChessBorad chessBorad = new ChessBorad();
        chessBorad.initChessBorad();
        chessBorad.printChessBorad();
    }
}
