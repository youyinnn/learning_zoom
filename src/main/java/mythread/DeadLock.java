package mythread;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/13
 */
public class DeadLock {
    private static StringBuffer a = new StringBuffer();
    private static StringBuffer b = new StringBuffer();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (a){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a.append("A");
                synchronized (b){
                    b.append("B");
                    System.out.println(a);
                    System.out.println(b);
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (b){
                b.append("C");
                synchronized (a){
                    b.append("D");
                    System.out.println(a);
                    System.out.println(b);
                }
            }
        }).start();
    }

}

