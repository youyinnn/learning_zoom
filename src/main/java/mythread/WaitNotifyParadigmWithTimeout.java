package mythread;

/**
 * @author youyinnn
 * Date 12/9/2018
 */
public class WaitNotifyParadigmWithTimeout {

    private static String lock = "lock";
    private static boolean wait = true;
    private static long timeout = 5000;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("T1 started to wait...");
                long left = timeout;
                long end = System.currentTimeMillis() + timeout;
                while (wait && left > 0) {
                    try {
                        lock.wait(left);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    left = end - System.currentTimeMillis();
                }
                System.out.println("T1 stop waitting !");
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("T2 processing: " + (i + 1));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lock) {
                System.out.println("T2 done process, notifyAll...");
                wait = false;
                lock.notifyAll();
            }
        }).start();
    }

}
