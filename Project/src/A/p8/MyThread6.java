package A.p8;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 使用可重入锁加condition来有选择的唤醒
 */
class PrintCount {
    /**
     * 标志位用来设置需要唤醒哪个线程
     */
    private int flag = 1;

    private final Lock myLock = new ReentrantLock();
    private final Condition condition1 = myLock.newCondition();
    private final Condition condition2 = myLock.newCondition();
    private final Condition condition3 = myLock.newCondition();
    private final Condition condition4 = myLock.newCondition();

    public void myPrint1() {
        //加锁
        myLock.lock();
        try {
            while (flag != 1) {
                condition1.await();
            }

            for (int i = 10; i <= 19; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //设置标志位
            flag = 2;

            //唤醒线程二的condition
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //最后释放锁，
            myLock.unlock();
        }
    }

    public void myPrint2() {
        myLock.lock();
        try {
            while (flag != 2) {
                condition2.await();
            }

            for (int i = 20; i <= 29; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //设置标志位
            flag = 3;

            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            myLock.unlock();
        }
    }

    public void myPrint3() {
        myLock.lock();
        try {
            while (flag != 3) {
                condition3.await();
            }

            for (int i = 30; i <= 39; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //设置标志位
            flag = 4;

            condition4.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            myLock.unlock();
        }
    }

    public void myPrint4() {
        myLock.lock();
        try {
            while (flag != 4) {
                condition4.await();
            }

            for (int i = 40; i <= 49; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //设置标志位
            flag = 1;

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            myLock.unlock();
        }
    }
}

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/10
 */
public class MyThread6 {
    public static void main(String[] args) {
        PrintCount printCount = new PrintCount();

        new Thread(() -> {
            printCount.myPrint1();
        }, "A").start();

        new Thread(() -> {
            printCount.myPrint2();
        }, "B").start();

        new Thread(() -> {
            printCount.myPrint3();
        }, "C").start();

        new Thread(() -> {
            printCount.myPrint4();
        }, "D").start();
    }
}