package MyThread.Reentrant.ReentrantReadWriteLock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/20
 *
 *
 * 读写锁内部维护读锁和写锁，依赖Sync实现具体功能，Sync继承自AQS
 * AQS维护一个state状态，读写锁使用高16位表示读状态，低16位表示写锁的可重入次数
 *
 */
public class ReentrantReadWriteLockListTest {
    private ArrayList<String> arrayList = new ArrayList<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void add(String e) {
        writeLock.lock();
        try {
            arrayList.add(e);
        } finally {
            writeLock.unlock();
        }
    }

    public void remove(String e) {
        writeLock.lock();
        try {
            arrayList.remove(e);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 读锁，可以使用多个线程来同时访问list
     * 在读多写少的时候性能更好
     */
    public String get(int index) {
        readLock.lock();
        try {
            return arrayList.get(index);
        } finally {
            readLock.unlock();
        }
    }
}
