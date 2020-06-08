package mythread.NoSynchronized;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/10
 */

/**
 * 这个程序会出现线程安全的问题：打印车票的时候 会出现重票或者错票的情况
 * 原因：
 *      由于一个线程在操作共享数据过程中 在未执行完毕的情况下 另外的线程参与进来 在资源情况和前一个线程一样的情况下执行任务
 *      就会出现资源分配出错的问题
 *
 * 解决：
 *      当一个线程在操作数据的时候 其他线程不能参与操作当前数据的任务
 */
public class testWindow2 {
    public static void main(String[] args) {
        Window2 window2 = new Window2();

        Thread w1 = new Thread(window2);
        Thread w2 = new Thread(window2);
        Thread w3 = new Thread(window2);

        w1.setName("[w1]");
        w2.setName("[w2]");
        w3.setName("[w3]");

        w1.start();
        w2.start();
        w3.start();
    }
}

class Window2 implements Runnable {
   int ticket = 100;

   @Override
   public void run() {
       while (true){
           if(ticket > 0){
               try {
                   Thread.currentThread().sleep(10);
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
