package mythread.Synchronized;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/11
 */
public class SynchronizedSingleton {

    public static void main(String[] args) {
        SingleTon singleTon = new SingleTon();

        Thread thread = new Thread(singleTon);
        thread.start();
        //加了这个方法 让主线程等待子线程创建好实例 这样 主线程就不会获取空
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
        System.out.println(singleTon.getInstance());

        for(int i = 0; i < 100 ; ++i){
            Thread t = new Thread(singleTon);
            t.start();
            System.out.println(singleTon.getInstance());
        }

    }
}

/**
 * 单例类
 */
class SinglePerson{
    private SinglePerson(){}

    private static SinglePerson instance;

    static SinglePerson getInstance() {
        synchronized (SinglePerson.class){
            if (instance == null){
                instance = new SinglePerson();
            }
        }
        return instance;
    }
}

/**
 * 专门获取单例的线程类
 */
class SingleTon implements Runnable{

    private SinglePerson instance;

    //线程启动就能获取单例
    @Override
    public void run() {
        instance = SinglePerson.getInstance();
    }

    SinglePerson getInstance() {
        return instance;
    }
}
