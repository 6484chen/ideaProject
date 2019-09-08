public class Test190806 {

    public static void main(String[] args) {
        t10();
        t34();
        t42();
    }

    //输出10*10的矩阵
    public static void t10(){
        int value=1;
        int [][] arrary=new int [10][10];
        for (int i = 0; i< 10 ; i++) {
            for (int j = 0; j < 10; j++) {
                arrary[i][j] = value;
                value++;
            }
        }
        for (int i = 0; i< 10 ; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(arrary[i][j]+" ");
            }
            System.out.println();
        }
    }


    //输出3*4的转置矩阵
    public static void printt34(int[][] arrary){
        for (int i = 0; i< 4 ; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arrary[j][i]+" ");
            }
            System.out.println();
        }
    }
    public static void t34() {
        int value = 1;
        int[][] arrary = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                arrary[i][j] = value;
                value++;
            }
        }
        printt34(arrary);
    }
    //四维数组
    public static void t42() {
        int value = 1;
        int[][][][] arrary = new int[2][2][2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        arrary[i][j][k][l] = value;
                        value++;
                    }
                }

            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        System.out.println(arrary[i][j][k][l]);
                    }
                }
            }
        }
    }
}
