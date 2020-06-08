package mythread;

/**
 * @author youyinnn
 * Date 12/23/2018
 */
public class TestProducerConsumer2 {

    static Integer limit = 50;
    static volatile Integer stock = 0;
    static final String P_LOCK = "p";
    static final String C_LOCK = "c";

    public static void main(String[] args) {
        new Thread(new Producer2("P-1")).start();
        new Thread(new Consumer2("C-1")).start();
        new Thread(new Consumer2("C-2")).start();
    }
}

class Producer2 implements Runnable {

    private String name;

    public Producer2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (TestProducerConsumer2.stock < TestProducerConsumer2.limit) {
                System.out.println("Producing");
                while (TestProducerConsumer2.stock < TestProducerConsumer2.limit) {
                    synchronized (TestProducerConsumer2.P_LOCK) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        TestProducerConsumer2.stock++;
                        System.out.println("Produced the " + TestProducerConsumer2.stock + " stock");
                    }
                }
                System.out.println("Produce process done");
                synchronized (TestProducerConsumer2.C_LOCK) {
                    TestProducerConsumer2.C_LOCK.notifyAll();
                }
            }
            synchronized (TestProducerConsumer2.P_LOCK) {
                try {
                    TestProducerConsumer2.P_LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer2 implements Runnable {

    private String name;

    public Consumer2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (TestProducerConsumer2.stock >= TestProducerConsumer2.limit) {
                System.out.println(name + " consuming");
                while (TestProducerConsumer2.stock > 0) {
                    synchronized (TestProducerConsumer2.C_LOCK) {
                        System.out.println(name + " consumed the " + TestProducerConsumer2.stock + " stock");
                        TestProducerConsumer2.stock--;
                    }
                }
                System.out.println(name + "consume process done");
                synchronized (TestProducerConsumer2.P_LOCK) {
                    TestProducerConsumer2.P_LOCK.notifyAll();
                }
            }
            synchronized (TestProducerConsumer2.C_LOCK) {
                try {
                    TestProducerConsumer2.C_LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
