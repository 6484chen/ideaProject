package test0824;

import java.util.Scanner;

/**
 * @ClassName XiaoXiaoLe
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/26 8:42
 * @Version 1.0
 */
public class XiaoXiaoLe {

    private int [][] array = new int[5][5];
    Scanner sc = new Scanner(System.in);
    private int count = 0;
/*
测试数据
1 2 3 1 1
2 1 1 1 2
2 1 2 1 3
2 1 2 3 2
2 2 2 3 2
 */
    public static void main(String[] args) {

        XiaoXiaoLe xiaoXiaoLe = new XiaoXiaoLe();
        System.out.println("输入矩阵：");
        xiaoXiaoLe.input();
        System.out.println("输入消除的位置,格式（x y）");
        String s = xiaoXiaoLe.sc.nextLine();
        String []pos = s.split(" ");
        //xiaoXiaoLe.start(Integer.parseInt(pos[0])-1,Integer.parseInt(pos[1])-1);
        int x = Integer.parseInt(pos[0])-1;
        int y = Integer.parseInt(pos[1])-1;
        xiaoXiaoLe.game(x,y,xiaoXiaoLe.array[x][y]);
        xiaoXiaoLe.printArray();


    }


    //保存输入数据
    public void input(){
        for (int i = 0; i < 5; i++) {
            String str = sc.nextLine();
            String str1 []  = str.split(" ");
            for (int j = 0; j < 5; j++) {
                array[i][j] = Integer.parseInt(str1[j]);
            }
        }
    }


    //输出矩阵
    public void printArray(){
        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j = 0; j < 5; j++) {
                System.out.print(array[i][j] + "\t");
            }
        }
    }



  /*  //判断是否开始消除
    public void start(int x, int y){
        int count = 1;
        try {
            if (array[x][y] == array[x][y + 1]) {
                count++;
            }
        }catch (Exception e){

        }try{
            if(array[x][y] == array[x+1][y]){
                count++;
            }
        }catch (Exception e){

        }try{
            if(array[x][y] == array[x][y-1]){
                count++;
            }
        }catch (Exception e){

        }try{
            if(array[x][y] == array[x-1][y]){
                count++;
            }
        }catch (Exception e){
        }

        if(count >= 3){
                game(x,y,array[x][y]);
            }else {
                System.out.println(x+","+y+"不可消除");
            }

    }*/
    //消除
    public void game(int x, int y,int temp) {

        try {
            if(y>0 && temp == array[x][y-1]){
                array[x][y] = 0;
                count++;
                game(x,y-1,temp);
            }else if(x>0 && temp == array[x-1][y]){
                array[x][y] = 0;
                count++;
                game(x-1,y,temp);
            }else if(y<4 && temp == array[x][y+1]){
                array[x][y] = 0;
                count++;
                game(x,y+1,temp);
            }else if(x<4 && temp == array[x+1][y]){
                array[x][y] = 0;
                count++;
                game(x+1,y,temp);
            }else{
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        /*try {
            if (temp == array[x][y + 1]) {
                array[x][y] = 0;
                game(x, y + 1);
            }else{
                return;
            }
        } catch (Exception e) {

        }
        try {
            if (temp == array[x + 1][y]) {
                array[x][y] = 0;
                game(x + 1, y);
            }else{
                return;
            }
        } catch (Exception e) {

        }
        try {
            if (temp == array[x][y - 1]) {
                array[x][y] = 0;
                game(x, y - 1);
            }else{
                return;
            }
        } catch (Exception e) {

        }
        try {
            if (temp == array[x - 1][y]) {
                array[x][y] = 0;
                game(x - 1, y);
            }else{
                return;
            }
        } catch (Exception e) {
        }*/
    }

    //数组下移
    public void move(){
        for (int i = 0; i < 5; i++) {
            int temp = 4;
            int count = 0;
            for (int j = 4; j >=0; j--) {
                if(array[j][i] == 0 && count != 1){
                    temp = j;
                    count++;
                }else if(array[j][i] != 0 && count ==1){
                    array[temp][i] = array[j][i];
                    array[j][i] = 0;
                    temp --;
                }
            }
        }
    }
}
