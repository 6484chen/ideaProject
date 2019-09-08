package test0821;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ProxyTest
 * @Description TODO
 * @Author 王琛
 * @Date 2019/8/21 16:44
 * @Version 1.0
 */
//1.创建接口
interface Subject{
    public void action();
}
//动态的特性
//1.1 创建i接口二

interface ClothFactory{
    public void cloth();
}
//2.创建被代理类
class Beidaili implements Subject{

    @Override
    public void action() {
        System.out.println("这是被代理类，action在执行");
    }
}
//2.1创建被代理对象二
class ClothProxy implements ClothFactory{

    @Override
    public void cloth() {

    }
}

//3.创建代理类
class MyProxy implements InvocationHandler {

    //创建被代理对象
    Object ob;

    public MyProxy(Object ob){
        this.ob = ob;
    }

    //绑定代理类
    public Object bind(){

        return Proxy.newProxyInstance(this.getClass().getClassLoader(), ob.getClass().getInterfaces(), this);
    }


    //实现InvocationHandler的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object invoke = method.invoke(ob, args);

        return invoke;
    }
}


public class ProxyTest {
    public static void main(String[] args) {
        //1创建被代理对象的接口
        Subject subject = new Beidaili();
        //2.创建代理对象
        MyProxy myProxy = new MyProxy(subject);

        //生成代理类接口
        Subject subject1 = (Subject) myProxy.bind();
        subject1.action();



        //2.
        //创建被代理对象
        ClothFactory cf = new ClothProxy();
        //
        MyProxy myProxy1 = new MyProxy(cf);
    }

}
