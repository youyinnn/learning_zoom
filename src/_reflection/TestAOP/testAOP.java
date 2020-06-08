package _reflection.TestAOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/27
 */

interface Human{
    void info();
    void fly();
}

class SuperMan implements Human{

    @Override
    public void info() {
        System.out.println("我是超人！");
    }

    @Override
    public void fly() {
        System.out.println("飞咯！");
    }
}

class HumanUtil{

    public void method1(){
        System.out.println("------------------通用前置处理----------------");
    }

    public void method2(){
        System.out.println("------------------通用后置处理 ----------------");
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object object;

    MyInvocationHandler(Object o){
        object = o;
    }

    public Object getProxyObject(){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil humanUtil = new HumanUtil();

        humanUtil.method1();

        Object returnVal = method.invoke(object,args);

        humanUtil.method2();

        return returnVal;
    }
}

class MyProxy{

    public static Object getProxyInstance(Object o){
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(o);

        return myInvocationHandler.getProxyObject();
    }
}

public class testAOP {

    public static void main(String[] args) {
        Human human = (Human) MyProxy.getProxyInstance(new SuperMan());
        human.info();
        System.out.println("***********");
        human.fly();

    }
}
