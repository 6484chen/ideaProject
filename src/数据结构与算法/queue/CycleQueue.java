package 数据结构与算法.queue;

/**
 * @ClassName CycleQueue
 * @Description 循环队列，优化数组队列
 * @Author 王琛
 * @Date 2019/9/5 15:37
 * @Version 1.0
 */


import java.util.Scanner;

/**
 * 思路：
 * 1.front 变量改为指向队列的第一个元素，arr【0】，front初始值为0
 * 2.rear 变量改为指向队列的最后一个元素的后一个位置，arr【length】,rear初始值为0
 * 3.将rear的后一个元素位置空下，做为一个空出一个空间的约定
 * 4.队列满的条件：（rear+1）% maxSize == front
 * 5.队列为空的条件： rear == front
 * 6.队列中的有效数据的个数为 （rear + maxSize -front）%maxSize。
 */

public class CycleQueue {
    public static void main(String[] args) {
        CycleQueueDemo queue = new CycleQueueDemo(5);   //实际队列最多可以使用3个
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
                        queue.show();
                    break;
                case 'h':
                    try {
                        queue.headShow();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    try {
                        System.out.println("输入添加的值：");
                        int value = scanner.nextInt();
                        queue.addQueue(value);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println("取出的值为："+queue.getQueue());
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


//使用数组模拟循环队列
class CycleQueueDemo{
    private  int maxSize;
    private  int front;
    private  int rear;
    private  int[] arr ;

    //队列的构造函数
    public CycleQueueDemo(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;  //指向队列头部，fount指向队列头的前一个位置
        rear = 0;  //指向队列尾部，指向队列为的数据（就是队列的最后一个数据）
    }

    //判断队列是否满
    public boolean full(){
        return ((rear+1)%maxSize == front);
    }

    //判断队列是否为空
    public boolean empty(){
        return front==rear;
    }

    //添加数据到队列，入队列
    public void  addQueue(int value){
        if(full()){
           throw new RuntimeException("队列已满！");
        }
        arr[rear] = value;
        rear=(rear+1)%maxSize;   //考虑取模
    }

    //获取队列的数据，出队列——》队列为空抛异常
    public int getQueue(){
        if(empty()){
            throw new RuntimeException("队列为空！");
        }
        //将front对应的值保存到一个临时变量中，为了使front后移，否则返回的值不一样
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void show(){
        if(empty()) {
            System.out.println("队列为空");
            return;
        }

        //思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.print(arr[i % maxSize]+"\t");
        }
        System.out.println();
    }

    //求出当前队列的有效个数
    public int size(){
        return (rear + maxSize - front) % maxSize;   //所有求模的小算法
    }

    //显示队列的头部
    public int headShow(){
        if(empty()){
            throw new  RuntimeException("头部为空");
        }else {
            System.out.println("队列头为："+arr[front]);
            return arr[front];
        }
    }


}