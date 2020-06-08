package mythread;

/**
 * @author youyinnn
 * Date 12/9/2018
 */
public class WaitNotifyParadigm {

    private static String lock = "lock";
    private static boolean wait = true;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("T1 started to wait...");
                while (wait) {
                    try {
                        lock.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("T1 stop waitting !");
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
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
