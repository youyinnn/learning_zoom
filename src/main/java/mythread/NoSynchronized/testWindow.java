package mythread.NoSynchronized;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/10
 */
public class testWindow {

    public static void main(String[] args) {
        Window w1 = new Window("[w1]");
        Window w2 = new Window("[w2]");
        Window w3 = new Window("[w3]");

        w1.start();
        w2.start();
        w3.start();

    }
}

class Window extends Thread{
    private static int ticket = 10;

    Window(String threadName){
        this.setName(threadName);
    }

    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName()+" selling ticket :"+ticket--);
            }else {
                break;
            }
        }
    }
}
