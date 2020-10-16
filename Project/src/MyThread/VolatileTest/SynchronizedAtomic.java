package MyThread.VolatileTest;


/**
 * @author Deep-Feeling-1999
 * @create 2020/10/14
 *
 * 使用Synchronized可以保证原子性（一系列操作全部执行完毕，不会只执行一部分）
 * 和内存可见性（更新后互相可见，保证是最新值）
 * 但是是重锁，会带来线程上下文切换的开销
 *
 * Volatile
 */
public class SynchronizedAtomic {
    private int value = 0;

    /**
     * 读的时候也要加锁，否则不能保证内存可见性
     * 即值发生变化后不能及时更新
     */
    public synchronized int getValue() {
        return value;
    }

    public synchronized void increment() {
        value++;
    }

}
