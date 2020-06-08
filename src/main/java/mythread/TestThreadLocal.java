package mythread;

import java.time.LocalDateTime;

/**
 * @author: youyinnn
 */
public class TestThreadLocal implements Runnable {

    @Override
    public void run() {
        ThreadLocalPropContainer.setThreadString(Thread.currentThread() + " " + LocalDateTime.now().getSecond() );
        ThreadLocalPropContainer.setThreadInteger(LocalDateTime.now().getSecond());
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ThreadLocalPropContainer.getThreadString());
        System.out.println(ThreadLocalPropContainer.getThreadInteger());
    }

    public static void main(String[] args) {
        TestThreadLocal t = new TestThreadLocal();
        new Thread(t,"t1").start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(t,"t2").start();
    }
}
