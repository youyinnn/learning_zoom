package mythread.Synchronized;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/10
 */
public class testWindow4 {

    public static void main(String[] args) {
        Window4 window = new Window4();
        Thread w1 = new Thread(window);
        Thread w2 = new Thread(window);
        Thread w3 = new Thread(window);

        w1.setName("[w One]");
        w2.setName("[w Two]");
        w3.setName("[w Three]");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window4 implements Runnable{
    private int ticket = 100;
    private boolean finishMark = false;

    @Override
    public void run() {
        while (!finishMark){
            show();
        }
    }

    private synchronized void show(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.interrupted();
        }
        if (ticket == 0) {
            finishMark = true;
        }else {
            System.out.println(Thread.currentThread().getName()+" : "+ticket--);
        }
    }
}
