package mythread;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/13
 */
public class testProducerConsumer {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        Consumer consumer = new Consumer(clerk);

        Thread p = new Thread(producer);
        Thread c = new Thread(consumer);

        p.start();
        c.start();

        while (true){
            if (clerk.getSell() == 60){
                System.out.println("[60点生产力已经使用完毕]");
                System.exit(0);
            }
        }

    }
}

//店员
class Clerk {
    private int goods = 5;
    private int sell = 0;

    synchronized int getSell() {
        return sell;
    }

    //进货
    synchronized void stock() {
        //如果生产
        if (goods == 5){
            System.out.println("[货满了]");
            notify();//唤醒消费者
            try {
                wait();//暂停生产
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if (goods >= 0){
            goods ++;
            System.out.println("[进货1件商品:存货"+goods+"]");
            notify();//
        }
    }

    //售货
    synchronized void selling() {
        if (goods == 0) {
            System.out.println("[没货了]");
            notify();//唤醒生产者
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            sell++;
            goods--;
            System.out.println("[销售第"+sell+"件商品]");
        }
    }

    synchronized int getGoods() {
        return goods;
    }
}

//生产者
class Producer implements Runnable {

    final Clerk clerk;

    Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            if (clerk.getGoods() == 0){
                while (clerk.getGoods() != 6){
                    product();
                    clerk.stock();
                }
            }
        }
    }

    private void product() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[生产1份商品]+++");
    }
}

//消费者
class Consumer implements Runnable {

    final Clerk clerk;

    Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            buy();
            clerk.selling();
        }
    }

    private void buy() {
        System.out.println("[购买1件商品]---");
    }


}
