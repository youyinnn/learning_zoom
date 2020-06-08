package mythread;

import org.junit.Test;

/**
 * @author youyinnn
 */
public class ThreadMessageTest {

    @Test
    public void testCurr(){
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().isAlive());
        System.out.println(Thread.currentThread().getState());
        System.out.println(Thread.currentThread().getPriority());
    }

    @Test
    public void testSleep() throws InterruptedException {
        Runnable sleep = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " sleep");
                Thread.sleep(10 * 1000);
                System.out.println("sleep done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t = new Thread(sleep, "sleepThread");
        //t.start();
        t.run();
        Thread.sleep(1000);
        System.out.println(t.getState() + "  " + t.getName());
    }

    @Test
    public void testInterrupted() throws InterruptedException {
        Thread t = new Thread();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        System.out.println(t.interrupted());
        System.out.println(t.interrupted());
    }

    int i = 0;

    @Test
    public void testEffectedInterrupt() throws InterruptedException {
        Runnable run = () -> {
            System.out.println(Thread.currentThread().getName());
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("interrupted!");
                    break;
                }
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println(i++);
            }
        };
        Thread t = new Thread(run, "runThread");
        t.start();
        Thread.sleep(10);
        t.interrupt();
    }

}
