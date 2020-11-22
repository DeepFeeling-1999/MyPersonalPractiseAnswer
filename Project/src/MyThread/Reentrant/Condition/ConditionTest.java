package MyThread.Reentrant.Condition;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/20
 */
public class ConditionTest {
    private static ReentrantLock reentrantLock = new ReentrantLock();
    private static Condition notFull = reentrantLock.newCondition();
    private static Condition notEmpty = reentrantLock.newCondition();
    private static Queue<String> queue = new LinkedBlockingQueue<>();

    private static final int QUEUE_SIZE = 1;

    public static void main(String[] args) {
        //生产者线程
        Thread producer = new Thread(() -> {
            reentrantLock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    //如果满了，生产者线程等待
                    while (queue.size() == QUEUE_SIZE) {
                        notEmpty.await();
                    }
                    queue.add("A");
                    System.out.println("生产一个A");

                    //唤醒消费者线程
                    notFull.signal();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        });

        //消费者线程
        Thread consumer = new Thread(() -> {
            reentrantLock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    //如果为空（没生产好），则等待
                    while (0 == queue.size()) {
                        notFull.await();
                    }
                    queue.poll();
                    System.out.println("消费一个A");

                    notEmpty.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        });

        producer.start();
        consumer.start();
    }

}
