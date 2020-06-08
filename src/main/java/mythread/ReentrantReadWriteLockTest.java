package mythread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author youyinnn
 * Date 1/10/2019
 */
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Lock r = lock.readLock();
        r.lock();
        r.lock();
        r.lock();
        r.lock();
        r.unlock();
        new Thread(() -> {
            r.lock();
            r.lock();
            r.lock();
            System.out.println(lock.getReadHoldCount());
            System.out.println(lock.getReadLockCount());
            r.unlock();
            r.unlock();
            r.unlock();
            System.out.println(lock.getReadHoldCount());
            System.out.println(lock.getReadLockCount());
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            r.lock();
            r.lock();
            r.lock();
            System.out.println(lock.getReadHoldCount());
            System.out.println(lock.getReadLockCount());
        }).start();
        TimeUnit.SECONDS.sleep(1);
        r.lock();
        r.lock();
        r.lock();
        r.unlock();
        System.out.println(lock.getReadHoldCount());
        System.out.println(lock.getReadLockCount());
    }

}
