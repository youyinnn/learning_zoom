package mythread;

import java.util.Random;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author youyinnn
 * Date 01/09/2019
 */
public class CacheTest {

    public static void main(String[] args) {
        Random random = new Random();
        new Thread(() -> {
            int dataCount = 0;
            while (true) {
                if (Cache.getSize() >= 50) {
                    continue;
                }
                int rCount = random.nextInt(5);
                for (int i = 0; i < rCount; i++) {
                    System.out.println(Cache.write("W1 write data: " + ++dataCount));
                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            int dataCount = 0;
            while (true) {
                if (Cache.getSize() >= 50) {
                    continue;
                }
                int rCount = random.nextInt(5);
                for (int i = 0; i < rCount; i++) {
                    System.out.println(Cache.write("W2 write data: " + ++dataCount));
                }
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                if (Cache.getSize() == 0) {
                    continue;
                }
                int rCount = random.nextInt(Cache.getSize());
                for (int i = 0; i < rCount; i++) {
                    System.out.println("R1 read data: " + Cache.read());
                }
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                if (Cache.getSize() == 0) {
                    continue;
                }
                int rCount = random.nextInt(Cache.getSize());
                for (int i = 0; i < rCount; i++) {
                    System.out.println("R2 read data: " + Cache.read());
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    static class Cache {
        private static Stack<String> stack = new Stack<>();
        private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        private static Lock r = rwl.readLock();
        private static Lock w = rwl.writeLock();

        public static Object read() {
            r.lock();
            try {
                return stack.pop();
            } finally {
                r.unlock();
            }
        }

        public static Object write(String data) {
            w.lock();
            try {
                return stack.push(data);
            } finally {
                w.unlock();
            }
        }

        public static void clear() {
            w.lock();
            try {
                stack.clear();
            } finally {
                w.unlock();
            }
        }

        public static int getSize() {
            r.lock();
            try {
                return stack.size();
            } finally {
                r.unlock();
            }
        }
    }
}