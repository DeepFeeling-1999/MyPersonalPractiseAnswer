package MyThread.CAS.AtomicLongTest;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/16
 *
 * 多线程使用AtomicLong统计0的个数
 * 内部使用unsafe方法，原子性设置value值为原始值+1
 */
public class Atomic {
    private static AtomicLong atomicLong = new AtomicLong();

    private static Integer[] arrayOne = new Integer[]{0, 1, 2, 0, 4, 5, 0, -9, 0, -8};
    private static Integer[] arrayTwo = new Integer[]{0, 1, 2, 0, 4, 0, 0, -9, 0, -8};

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            int size = arrayOne.length;
            for (int i = 0; i < size; ++i) {
                if (arrayOne[i].intValue() == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < arrayTwo.length; ++i) {
                if (arrayTwo[i].intValue() == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        });
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();

        System.out.println("count 0: "+atomicLong.get());

    }
}
