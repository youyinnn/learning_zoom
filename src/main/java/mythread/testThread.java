package mythread;

/**
 * @author: youyinnn
 */
public class testThread {
    public static void main(String[] args) {
        //3、创建子类独对象
        SubThread subThread = new SubThread();
        //4、调用线程start方法 启动线程 调用run方法
        //5、run方法 并不启动线程
        subThread.start();
    }
}

//1、创建一个继承Thread类的子类
class SubThread extends Thread{
    //2、重写Thread类的run方法，方法内实现这个线程需要做的功能。

    @Override
    public void run() {
        super.setName("子线程");
        for (int i = 0; i< 10 ; ++i){
            System.out.println(Thread.currentThread().getName()+":线程方法");
        }
    }
}


