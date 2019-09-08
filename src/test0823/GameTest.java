/**
 * 公司：金刚葫芦娃
 * 文件名：GameTest
 * 作者：ZhaoJinGang
 * 时间：2019/8/22 20:12
 * 描述：
 */

package test0823;

public class GameTest {

    public static void main(String[] args) {

        Game game = new Game();
        ChessBoard chessBoard = new ChessBoard();
        ChessPiece chessPiece = null;

        System.out.println("============ 游戏开始 ============");
        // 输出当前的棋盘
        game.writeChessBoard(chessBoard);

        int play = 1;
        while (true) {

            // 选手下棋
            while (true) {
                chessPiece = game.play(play, chessBoard);
                if (chessPiece == null) {
                    continue;
                } else {
                    play = -chessPiece.color;
                    break;
                }
            }


            // 输出当前的棋盘
            game.writeChessBoard(chessBoard);


            // 判断输赢
            int win = game.isWin(chessBoard, chessPiece);
            if (win == 1) {
                System.out.println("黑棋胜利！");
                break;
            } else if (win == -1) {
                System.out.println("白棋胜利！");
                break;
            }
            System.out.println("\n============================================\n");
        }
    }

}
