package mythread.Synchronized;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/10
 */

/**
 * 使用同步代码块的方法解决线程安全问题
 */
public class testWindow3 {
    public static void main(String[] args) {
        Window3 window3 = new Window3();

        Thread w1 = new Thread(window3);
        Thread w2 = new Thread(window3);
        Thread w3 = new Thread(window3);

        w1.setName("[w1]");
        w2.setName("[w2]");
        w3.setName("[w3]");

        w1.start();
        w2.start();
        w3.start();
    }
}

 class Window3 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            synchronized (this){
                if(ticket > 0){
                    try{
                        Thread.currentThread().sleep(10);;
                    } catch (InterruptedException e) {
                        Thread.interrupted();
                    }
                    System.out.println(Thread.currentThread().getName()+" selling ticket : "+ticket--);
                }else {
                    break;
                }
            }
        }
    }
}
