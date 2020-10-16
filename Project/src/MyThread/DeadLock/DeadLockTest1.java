package MyThread.DeadLock;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/14
 *
 * 死锁产生条件
 * //不可解决的两个条件
 * 互斥，即该资源同时只能由一个线程占用，别的请求者只能等待释放
 * 不可剥夺，即已获取的锁在使用完之前不会被抢占
 *
 * //可被破坏的两个条件（资源请求的有序性）
 * 请求并持有，持有了至少一个资源后请求别的资源，因新资源已经被占有所以阻塞
 * 但同时不会释放自身已获取的锁
 * 环路等待，即会构成请求资源链条，而造成互相等待已经被持有的资源
 */
public class DeadLockTest1 {
    private static Object resourcesA = new Object();
    private static Object resourcesB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            synchronized(resourcesA) {
                System.out.println(Thread.currentThread() + " 获取到sourcesA");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread() + " 尝试获取sourcesB");

                synchronized(resourcesB) {
                    System.out.println(Thread.currentThread() + " 获取到资源B");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized(resourcesB) {
                System.out.println(Thread.currentThread() + " 获取到sourcesB");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread() + " 尝试获取sourcesB");

                synchronized(resourcesA) {
                    System.out.println(Thread.currentThread() + " 获取到资源A");
                }
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
    }

}
