package mythread;

import java.util.concurrent.TimeUnit;

/**
 * @author youyinnn
 * Date 12/26/2018
 */
public class TestInterruptedSynchronized {

    public static void main(String[] args) throws InterruptedException {
        String lockA = "A";
        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("T1 get LockA");
                while (true) {
                }
            }
        });
        Thread t2= new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2 trying to get LockA");
            synchronized (lockA) {
                System.out.println("T2 get LockA");
            }
        });
        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(3);
        while (t2.isAlive() && t1.isAlive()) {
            TimeUnit.MILLISECONDS.sleep(300);
            if (!t1.isInterrupted()) {t1.interrupt();}
            if (!t2.isInterrupted()) {t2.interrupt();}
            System.out.println("T1 Alive: " + t1.isAlive() + ", isInterrupted: " + t1.isInterrupted() + ", State: " + t1.getState());
            System.out.println("T2 Alive: " + t2.isAlive() + ", isInterrupted: " + t2.isInterrupted() + ", State: " + t2.getState());
        }
    }

}
