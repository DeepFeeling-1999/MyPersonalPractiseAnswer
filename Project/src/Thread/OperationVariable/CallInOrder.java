package Thread.OperationVariable;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PrintCount {
    private int flag = 1;
    private Lock myLock = new ReentrantLock();
    private final Condition condition1 = myLock.newCondition();
    private final Condition condition2 = myLock.newCondition();
    private final Condition condition3 = myLock.newCondition();


    public void myPrint1() {
        myLock.lock();
        try {
            while (flag != 1) {
                condition1.await();
            }

            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //设置标志位
            flag=2;

            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            myLock.unlock();
        }
    }

    public void myPrint2() {
        myLock.lock();
        try {
            while (flag !=2) {
                condition2.await();
            }

            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //设置标志位
            flag=3;

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
            while (flag !=3) {
                condition3.await();
            }

            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //设置标志位
            flag=1;

            condition3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            myLock.unlock();
        }
    }
}

public class CallInOrder {
    public static void main(String[] args) {
        PrintCount printCount = new PrintCount();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                printCount.myPrint1();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                printCount.myPrint2();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                printCount.myPrint3();
            }
        }, "C").start();
    }

}
