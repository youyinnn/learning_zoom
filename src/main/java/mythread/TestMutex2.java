package mythread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author youyinnn
 * Date 1/6/2019
 */
public class TestMutex2 {

    public static void main(String[] args) throws InterruptedException {
        Mutex mutex = new Mutex();
        mutex.lock();
        System.out.println("mutex get lock !");
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            System.out.println("mutex get try get lock again");
            mutex.lock();
        }).start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(() -> {
            System.out.println("mutex get try get lock again");
            mutex.lock();
        }).start();
    }

}

class TwinsLock implements Lock {

    private Q q = new Q();
    class Q extends AbstractQueuedSynchronizer {

        Q() {
            setState(2);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            for (; ; ) {
                int current = getState();
                int newState = current - arg;
                if (newState < 0 || compareAndSetState(current, newState)) {
                    return newState;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (; ; ) {
                int current = getState();
                int newState = current + arg;
                if (compareAndSetState(current, newState)) {
                    return true;
                }
            }
        }
    }

    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
