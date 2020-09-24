package Thread.SaleTicket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类=实例变量+实例方法
 */
class SaleSystem {
    private int amount = 40;

    /**
     * 可重入锁
     */
    Lock myLock = new ReentrantLock();

    public void saleTicket() {
        myLock.lock();

        try {
            if (amount > 0) {
                System.out.println(Thread.currentThread().getName() + "\t 卖出第：" + (amount--) + "\t" + "还剩" + amount);
            }
        } finally {
            myLock.unlock();
        }
    }
}

public class Sale {
    public static void main(String[] args) {
        SaleSystem saleSystem = new SaleSystem();

        new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                saleSystem.saleTicket();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                saleSystem.saleTicket();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 40; i++) {
                saleSystem.saleTicket();
            }
        }, "C").start();


        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<=40;i++){
                    saleSystem.saleTicket();
                }
            }
        }, "aaa").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<=40;i++){
                    saleSystem.saleTicket();
                }
            }
        }, "bbb").start();*/

        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<=40;i++){
                    saleSystem.saleTicket();
                }
            }
        }, "ccc").start();
        */

        /**
         * NEW，RUNNABLE，BLOCK，WAITING(不见不散)，TIMED_WAITING(过时不候)，
         */
    }
}
