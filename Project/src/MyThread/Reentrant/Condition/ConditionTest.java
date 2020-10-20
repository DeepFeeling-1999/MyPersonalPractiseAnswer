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
    private static Condition producerCondition = reentrantLock.newCondition();
    private static Condition consumerCondition = reentrantLock.newCondition();
    private static Queue<String> queue = new LinkedBlockingQueue<>();

    private static final int queueSize = 10;

    public static void main(String[] args) {
        //生产者线程
        Thread producer = new Thread(() -> {
            reentrantLock.lock();
            try{
                //如果满了，生产者线程等待
                while(queue.size()==queueSize){
                    producerCondition.await();
                }
                queue.add("A");
                System.out.println("生产一个A");

                //唤醒消费者线程
                consumerCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        });

        //消费者线程
        Thread consumer = new Thread(() -> {
            reentrantLock.lock();
            try{
                //如果为空（没生产好），则等待
                while(0==queue.size()){
                    consumerCondition.await();
                }
                queue.poll();
                System.out.println("消费一个A");

                producerCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        });

        producer.start();
        consumer.start();
    }

}
