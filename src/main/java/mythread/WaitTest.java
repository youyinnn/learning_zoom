package mythread;

/**
 * @author youyinnn
 * Date 12/9/2018
 */
public class WaitTest {

    private static String lockA = "la";
    private static String lockB = "lb";

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lockA) {
                System.out.println("T1 got locak A");
                synchronized (lockB) {
                    System.out.println("T1 got locak B");
                    try {
                        System.out.println("T1 wait, released lockA for now");
                        lockA.wait(5000);
                        System.out.println("T1 come back from wait, and got lockA again");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("T1 released lockB");
            }
            System.out.println("T1 released lockA finally");
        }).start();
        new Thread(() -> {
            System.out.println("T2 sleep 3 seconds");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockA) {
                System.out.println("T2 got lockA, and sleep 6 sec");
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("T2 released lockA");
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T3 wanna get lockB");
            synchronized (lockB) {
                System.out.println("T3 got lockB");
            }
            System.out.println("T3 released lockB");
        }).start();
    }
}
