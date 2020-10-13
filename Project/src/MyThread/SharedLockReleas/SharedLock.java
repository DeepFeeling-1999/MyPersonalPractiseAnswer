package MyThread.SharedLockReleas;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/13
 *
 * 证明当线程调用共享对象的wait()方法时只会释放此共享对象的锁
 * 当前线程持有的其他共享对象的监视器锁并不会被释放
 *
 */
public class SharedLock {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            try {
                synchronized(resourceA) {
                    System.out.println("线程A 获得A锁");
                    synchronized(resourceB) {
                        System.out.println("线程A 获得B锁");
                        System.out.println("线程A阻塞，并释放获取的A锁");
                        resourceA.wait();

                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                Thread.sleep(1000);
                synchronized(resourceA) {
                    System.out.println("线程B 获得A锁");
                    System.out.println("线程B 尝试获取B锁");
                    synchronized(resourceB) {
                        System.out.println("线程B 获得B锁");
                        System.out.println("线程A阻塞，并释放获取的A锁");
                        resourceA.wait();

                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("main 结束");
    }


}
