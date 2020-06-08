package mythread;

import java.time.LocalTime;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/10
 */
public class testThreadUsefulMethod {

    public static void main(String[] args) {
        testPriority();
    }

    public static void testYield() {
        SubThread2 subThread = new SubThread2();
        subThread.setName("子线程");
        subThread.start();

        for (int i = 0; i < 100; ++i) {
            System.out.println(Thread.currentThread().getName() + ":线程方法:" + i);
            if (i % 2 == 0) {
                Thread.currentThread();
                Thread.yield();
            }
        }
    }


    public static void testJoin() {
        SubThread2 subThread = new SubThread2();
        subThread.setName("子线程");
        subThread.start();

        for (int i = 0; i < 100; ++i) {
            System.out.println(Thread.currentThread().getName() + "主线程方法:" + i);
            if (i == 20) {
                try {
                    subThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public static void testSleep() {
        System.out.println(LocalTime.now().withNano(0));
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(LocalTime.now().withNano(0));
    }


    public static void testPriority(){
        SubThread2 a = new SubThread2();
        a.setName("[Thread AAA]");
        a.setPriority(10);
        SubThread2 b = new SubThread2();
        b.setName("[Thread B]");
        b.setPriority(5);

        a.start();
        b.start();
    }

}

//1、创建一个继承Thread类的子类
class SubThread2 extends Thread{
    //2、重写Thread类的run方法，方法内实现这个线程需要做的功能。
    @Override
    public void run() {
        for (int i = 0; i< 100 ; ++i){
            System.out.println(Thread.currentThread().getName()+":线程方法:"+i);
        }
    }
}
