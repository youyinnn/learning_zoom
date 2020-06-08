package mythread;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/10
 */
public class testImplRunnable {
    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();
        //启动线程 执行Thread对象构造时传入的对象的run方法
        Thread thread = new Thread(printNumber);
        thread.start();

        Thread thread2 = new Thread(printNumber);
        thread2.start();
    }
}

class PrintNumber implements Runnable{

    @Override
    public void run() {
        for (int i = 0 ; i < 10 ; ++i){
            System.out.println(i);
        }
    }
}
