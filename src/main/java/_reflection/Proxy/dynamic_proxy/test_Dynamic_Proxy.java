package _reflection.Proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/23
 */

interface AEvent{
    void ActionA();
}

//被代理类
interface BEvent{
    void ActionB();
}

class Me implements AEvent ,BEvent{

    @Override
    public void ActionA() {
        System.out.println("事件A");
    }
    @Override
    public void ActionB() {
        System.out.println("事件B");
    }

}


class MyInvocationHandler implements InvocationHandler{

    Object object;//实现了接口的被代理类的对象的声明 也是我们要代理的真实对象

    //给被代理类的对象实例化
    //返回代理类对象
    public Object blind(Object o){

        object = o;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                o.getClass().getInterfaces(),this);
    }

    //当通过代理类对象发起对被重写的方法的调用时 都会转化为对如下的invoke方法的调用
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(object, args);
    }
}

public class test_Dynamic_Proxy {

    public static void main(String[] args) {

        //创建一个实现了InvocationHandler方法的接口的类的对象
        MyInvocationHandler handler = new MyInvocationHandler();

        //被代理类对象
        Me me = new Me();
        //调用blind()方法 动态返回一个同样实现了real所在类实现的接口的Subject代理类的对象
        Object object = handler.blind(me);
        //subject就是代理类的对象
        AEvent aEvent = (AEvent) object;
        aEvent.ActionA();


        System.out.println("----------------");

        BEvent bEvent = (BEvent) handler.blind(me);
        bEvent.ActionB();
    }
}
