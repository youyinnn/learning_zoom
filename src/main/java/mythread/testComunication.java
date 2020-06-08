package mythread;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/13
 */
public class testComunication {

    public static void main(String[] args) {
        PrintNumber2 printNumber2 = new PrintNumber2();
        Thread t1 = new Thread(printNumber2);
        Thread t2 = new Thread(printNumber2);

        t1.setName("[A]");
        t2.setName("[ B ]");

        t2.start();
        t1.start();

    }
}

class PrintNumber2 implements Runnable{

    private int num = 1;

    @Override
    public void run() {
        while (true){
            synchronized (this){
                notify();
                if (num <= 100){
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println(Thread.currentThread().getName()+" : "+num++);
                }else {
                    break;
                }
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
