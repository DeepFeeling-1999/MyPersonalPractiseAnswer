package Thread.myReentrantLock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 判断，干活，通知别的线程
 * <p>
 * 多线程判断必须要用while，不能用if，以防止虚假唤醒
 *
 *
 * ReentrantLock 可重入锁，默认是非公平的，构造时传入true会变成公平锁
 *
 * 在资源类被使用的时候，公平和非公平锁的新线程都会进入等待队列
 * 当结束使用的时候，非公平锁新加入的线程会和等待队列的头线程一起抢
 * 抢失败的话会进入队尾（FIFO）
 * 而公平锁是直接进入队尾
 *
 *
 *
 * 可重入锁配合Condition使用可以解决wait和notify唤醒不方便的情况
 * Condition中在线程持有锁后只有await()方法有可能释放锁，然后挂起线程，一旦条件满足就被唤醒，再次获取锁。
 */
class Aircondition {
    private int number = 0;

    private Lock myLock = new ReentrantLock();
    private final Condition conditionIncrement=myLock.newCondition();
    private final Condition conditionDecrement=myLock.newCondition();


    public void increment(Condition condition) throws Exception {
        myLock.lock();
        try {
            while (number != 0) {
                condition.await();
            }

            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);

            conditionDecrement.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放锁
            myLock.unlock();
        }
    }

    public void decrement(Condition condition)throws Exception{
        myLock.lock();
        try {
            while (number == 0) {
                //使线程在等待，直到被另一个线程唤醒
                condition.await();
            }

            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            conditionIncrement.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            myLock.unlock();
        }
    }

    public void TestReentrantLockCondition(){
        new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    increment(conditionIncrement);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                for (int i = 1; i <= 40; i++) {
                    decrement(conditionDecrement);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();

        //new Thread(() -> {
        //    try {
        //        for (int i = 1; i <= 10; i++) {
        //            increment(conditionC);
        //        }
        //    } catch (Exception e) {
        //        e.printStackTrace();
        //    }
        //}, "C").start();

    }
    /**
     public synchronized void increment()throws Exception{
     //判断
     while(number!=0){
     wait();
     }

     //干活
     number++;
     System.out.println(Thread.currentThread().getName()+"\t"+number);

     //唤醒其他等待的线程
     this.notifyAll();
     }
     }*/
}

public class Test {

    public static void main(String[] args) {
        Aircondition aircondition = new Aircondition();
        aircondition.TestReentrantLockCondition();
    }

}

