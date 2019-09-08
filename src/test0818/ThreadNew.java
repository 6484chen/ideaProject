package test0818;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * 创建线程的方式三    --jdk5.0 新增
 *实现Callable的接口比实现Runnable接口更强大
 *
 * 1.callable可以有返回值
 * 2.call方法可以抛出异常，被外面的操作捕获，获取线程的异常信息
 * 3.callable可以支持泛型
 *
 * @ClassName ThreadNew
 * @Description 新的创建线程方式
 * @Author 王琛
 * @Date 2019/8/28 11:56
 * @Version 1.0
 */

//1.创建一个Callable的实现类
class NumThread implements Callable{
    //2.实现Call方法，将此线程需要实现的执行操作声明在call（）声明中
    @Override
    public Object call() throws Exception {

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if( i % 2 == 0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}


public class ThreadNew {
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NumThread numThread = new NumThread();
        //4.将Callable实现类的对象作为值传递到FutureTask构造器中，创建FutureTask的对象中
        FutureTask futureTask = new FutureTask(numThread);
        //5.启动线程，将FutureTask的对象作为参数传递到Thread类的构造器中，启动线程
        new Thread(futureTask).start();
        try {
            //6.获取Callable中call方法的返回值
            Object sum = futureTask.get();
            System.out.println("总和为："+sum);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


