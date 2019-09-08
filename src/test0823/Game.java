/**
 * 公司：金刚葫芦娃
 * 文件名：Game
 * 作者：ZhaoJinGang
 * 时间：2019/8/22 18:32
 * 描述：
 */

package test0823;

import java.util.Scanner;

public class Game {

    /**
     * 输出当前的棋盘
     */
    public void writeChessBoard(ChessBoard chessBoard) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (chessBoard.chessBoard[i][j] == 0) {
                    System.out.print("*  ");
                } else if (chessBoard.chessBoard[i][j] == 1) {
                    System.out.print("=  ");
                } else {
                    System.out.print("+  ");
                }
            }
            System.out.println();
        }
    }


    /**
     * 选手下棋
     *
     * @param play
     * @param chessBoard
     * @return
     */
    public ChessPiece play(int play, ChessBoard chessBoard) {
        ChessPiece chessPiece = new ChessPiece();
        Scanner in = new Scanner(System.in);
        String line = null;
        String[] xy = null;

        if (play == 1) {
            System.out.println("请黑棋选手下棋");
        } else if (play == -1) {
            System.out.println("请白棋选手下棋");
        }

        line = in.nextLine();
        try {
            xy = line.split(" ");
            if (chessBoard.chessBoard[new Integer(xy[0])][new Integer(xy[1])] != 0) {
                System.out.println("此处有子！");
                return null;
            }
        } catch (Exception e) {
            return null;
        }

        chessBoard.chessBoard[new Integer(xy[0])][new Integer(xy[1])] = play;
        chessPiece.color = play;

        chessPiece.x = new Integer(xy[0]);
        chessPiece.y = new Integer(xy[1]);
        return chessPiece;
    }


    /**
     * 判断  输赢
     *
     * @param chessBoard
     * @param chessPiece
     * @return
     */
    public int isWin(ChessBoard chessBoard, ChessPiece chessPiece) {
        int count = 1;
        count = zong(count, chessBoard, chessPiece);
        if (count >= 5) {
            return chessPiece.color;
        }

        count = 1;
        count = heng(count, chessBoard, chessPiece);
        if (count >= 5) {
            return chessPiece.color;
        }

        count = 1;
        count = youxie(count, chessBoard, chessPiece);
        if (count >= 5) {
            return chessPiece.color;
        }

        count = 1;
        count = zuoxie(count, chessBoard, chessPiece);
        if (count >= 5) {
            return chessPiece.color;
        }

        return 0;
    }

    /**
     * 判断 纵向
     *
     * @param count
     * @param chessBoard
     * @param chessPiece
     * @return
     */
    public int zong(int count, ChessBoard chessBoard, ChessPiece chessPiece) {

            for (int i = 1; i < 5; i++) {
                if (chessBoard.chessBoard[chessPiece.x - i][chessPiece.y] == chessPiece.color) {
                    count++;
                } else {
                    break;
                }
            }


            for (int i = 1; i < 5; i++) {
                if (chessBoard.chessBoard[chessPiece.x + i][chessPiece.y] == chessPiece.color) {
                    count++;
                } else {
                    break;
                }
            }

        return count;
    }

    /**
     * 判断 横向
     *
     * @param count
     * @param chessBoard
     * @param chessPiece
     * @return
     */
    public int heng(int count, ChessBoard chessBoard, ChessPiece chessPiece) {
        try {
            for (int i = 1; i < 5; i++) {
                if (chessBoard.chessBoard[chessPiece.x][chessPiece.y - i] == chessPiece.color) {
                    count++;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
        }
        try {
            for (int i = 1; i < 5; i++) {
                if (chessBoard.chessBoard[chessPiece.x][chessPiece.y + i] == chessPiece.color) {
                    count++;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
        }
        return count;
    }

    /**
     * 判断  \
     *
     * @param count
     * @param chessBoard
     * @param chessPiece
     * @return
     */
    public int youxie(int count, ChessBoard chessBoard, ChessPiece chessPiece) {
        try {
            for (int i = 1; i < 5; i++) {
                if (chessBoard.chessBoard[chessPiece.x - i][chessPiece.y - i] == chessPiece.color) {
                    count++;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
        }
        try {
            for (int i = 1; i < 5; i++) {
                if (chessBoard.chessBoard[chessPiece.x + i][chessPiece.y + i] == chessPiece.color) {
                    count++;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
        }
        return count;
    }

    /**
     * 判断  /
     *
     * @param count
     * @param chessBoard
     * @param chessPiece
     * @return
     */
    public int zuoxie(int count, ChessBoard chessBoard, ChessPiece chessPiece) {
        try {
            for (int i = 1; i < 5; i++) {
                if (chessBoard.chessBoard[chessPiece.x - i][chessPiece.y + i] == chessPiece.color) {
                    count++;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
        }
        try {
            for (int i = 1; i < 5; i++) {
                if (chessBoard.chessBoard[chessPiece.x + i][chessPiece.y - i] == chessPiece.color) {
                    count++;
                } else {
                    break;
                }
            }
        } catch (Exception e) {
        }
        return count;
    }

}
