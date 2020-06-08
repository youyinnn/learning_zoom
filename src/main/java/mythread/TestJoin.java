package mythread;

/**
 * @author youyinnn
 * Date 12/24/2018
 */
public class TestJoin implements Runnable{

    private Thread pre;
    private String name;

    public TestJoin(Thread pre, String name) {
        this.pre = pre;
        this.name = name;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main run");
        Thread pre = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new TestJoin(pre, (i + 1) + ""));
            thread.start();
            pre = thread;
        }
        Thread.sleep(3000);
        System.out.println("main exit");
    }

    @Override
    public void run() {
        System.out.println(name + " run now");
        try {
            pre.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " exit now");
    }
}
