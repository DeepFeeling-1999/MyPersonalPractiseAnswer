package MyThread.ThreadLocalRandomTest;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/16
 *
 * ThreadLocalRandom解决多线程共用种子的伪随机
 * 其中并没有存放具体的种子，而是存放在具体调用线程的threadLocalRandomSeed变量中
 * 调用current方法获取实例时会初始化调用线程的种子变量（第一次调用才会初始化）
 * 且获取的是同一个实例，但是因为种子是存放在线程里的，所以安全
 *
 * 调用nexInt时会使用原来的种子来更新新的种子并保存在当前线程
 */
public class RandomTest {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+random.nextInt(5));
            }
        },"A");

        Thread threadTwo = new Thread(() -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();

            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+random.nextInt(5));
            }
        },"B");

        threadOne.start();
        threadOne.join();
        threadTwo.start();

    }
}
