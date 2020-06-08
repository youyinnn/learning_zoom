package mythread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author youyinnn
 * Date 12/26/2018
 */
public class TestReentrantLock {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(true);
        Thread t1 = new Thread(() -> {
            lock.lock();
            System.out.println("T1 get reentrantLock");
            try {
                while (true) {
                }
            } finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2 trying to get reentrantLock");
            lock.lock();
            try {
                System.out.println("T2 get reentrantLock");
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        t2.start();
        //TimeUnit.SECONDS.sleep(3);
        //while (t2.isAlive() && t1.isAlive()) {
        //    TimeUnit.MILLISECONDS.sleep(2000);
        //    t1.interrupt();
        //    t2.interrupt();
        //    System.out.println("T1 Alive: " + t1.isAlive() + ", isInterrupted: " + t1.isInterrupted() + ", State: " + t1.getState());
        //    System.out.println("T2 Alive: " + t2.isAlive() + ", isInterrupted: " + t2.isInterrupted() + ", State: " + t2.getState());
        //}
    }

}
