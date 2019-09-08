package 数据结构与算法.queue;

import java.util.Scanner;

/**
 * @ClassName ArrayQueue
 * @Description 数组模拟队列，只能使用一次
 * @Author 王琛
 * @Date 2019/9/5 14:39
 * @Version 1.0
 */
public class ArrayQueue {
    public static void main(String[] args) {
        ArrayQueueDemo queue = new ArrayQueueDemo(3);
        char a = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("1.输入s（show）显示队列数据");
            System.out.println("1.输入a（add）添加数据");
            System.out.println("1.输入g（get）取出队列数据");
            System.out.println("1.输入h（headQueue）显示队列头部");
            System.out.println("1.输入e（exit）退出");
            System.out.println("===================================");
            a = scanner.next().charAt(0);
            switch (a){
                case 's':
                    try {
                        queue.show();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        queue.headShow();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("输入添加的值：");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        queue.getQueue();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;

                    break;
            }
        }
        System.out.println("已退出");
    }
}

//使用数组模拟队列
class ArrayQueueDemo{
    private  int maxSize;
    private  int front;
    private  int rear;
    private  int[] arr ;

    //队列的构造函数
    public ArrayQueueDemo(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;  //指向队列头部，fount指向队列头的前一个位置
        rear = -1;  //指向队列尾部，指向队列为的数据（就是队列的最后一个数据）
    }

    //判断队列是否满
    public boolean full(){
        if(rear == maxSize-1) {
            System.out.println("队列已满！");
            return false;   //队列已满
        }
        return true;

    }

    //判断队列是否为空
    public boolean empty(){
        if(front==rear){
            throw new RuntimeException("队列为空");
        }
        return true;
    }

    //添加数据到队列，入队列
    public void  addQueue(int value){
        if(full()){
            rear++;
            arr[rear] = value;
        }
    }

    //获取队列的数据，出队列——》队列为空抛异常
    public void getQueue(){
        if(empty()){
            front++;
            System.out.println("取出的数据为："+arr[front]);
        }
    }

    //显示队列的所有数据
    public void show(){
        if(empty()) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "\t");
            }
            System.out.println();
        }
    }

    //显示队列的头部
    public int headShow(){
        if(empty()){
            System.out.println("队列头为："+arr[front+1]);
            return arr[front+1];
        }else {
            throw new  RuntimeException("头部为空");
        }
    }


}
