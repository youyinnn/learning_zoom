package mythread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author youyinnn
 * Date 12/29/2018
 */
public class MutexTest {

    public static void main(String[] args) {
        Mutex mutex = new Mutex();
        Thread t1 = new Thread(() -> {
            System.out.println("T1 trying get mutex");
            mutex.lock();
            System.out.println("T1 get mutex");
            while (mutex.isLocked()) {}
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2 trying get mutex and might get blocked");
            mutex.lock();
            System.out.println("T2 get mutex");
        });
        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T3 trying to get mutex but not get blocked");
            boolean tryLock = mutex.tryLock();
            int count = 0;
            while (!tryLock) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T3 try again at: " + ++count);
                tryLock = mutex.tryLock();
                if (count == 5) {
                    System.out.println("T3 tried 5 times and it got angry so it unlock the mutex !");
                    mutex.unlock();
                    count = 0;
                }
            }
            System.out.println("T3 get mutex");
        });
        t1.start();
        t2.start();
        t3.start();
    }

}

class Mutex implements Lock {

    static class Q extends AbstractQueuedSynchronizer {

        @Override
        protected boolean isHeldExclusively() {
            // 查看是否处于占用状态
            return getState() == 1;
        }

        @Override
        public boolean tryAcquire(int acquire) {
            // 状态为0的时候获取锁
            if (compareAndSetState(0, acquire)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int release) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            // 释放锁并将状态设置为0
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition newCondition() {
            // 返回一个Condition对象 每一个conditionObject都包含了一个condition队列
            return new ConditionObject();
        }

        public Thread getOwnerThread() {
            return getExclusiveOwnerThread();
        }
    }

    private final Q q = new Q();

    @Override
    public void lock() {
        q.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        q.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return q.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return q.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        q.release(1);
    }

    @Override
    public Condition newCondition() {
        return q.newCondition();
    }

    // 可以额外附加的实现

    public boolean isLocked() {
        return q.isHeldExclusively();
    }
    public boolean hasQueuedThreads() {
        return q.hasQueuedThreads();
    }

    public Thread getExclusiveOwnerThread() {
        return q.getOwnerThread();
    }
}
