package Thread.CountDownLattchDemo;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch用来线程计数，安排所有线程完成后的最终执行
 *
 * 当一个或多个线程调用await方法时，这些线程会阻塞
 * 其他线程调用countDown方法会将计数器减1（调用countDown方法不会阻塞）
 * 当计数器的值变为0时，因await阻塞的方法会被唤醒，继续执行
 */
public class TestDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "线程内");

                //计数减1
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName() + "\t结束");

    }

    public static void closeDoor() {
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "线程内");
            }, String.valueOf(i)).start();
        }
            System.out.println(Thread.currentThread().getName() + "main结束");

    }
}
