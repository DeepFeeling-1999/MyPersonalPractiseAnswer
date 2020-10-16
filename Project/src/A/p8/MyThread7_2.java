package A.p8;

import java.util.concurrent.*;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/10
 *
 * 交替输出a和b
 * 使用synchronized锁住共享对象
 * 然后在for里输出一次则wait等待且唤醒另一个线程
 */
public class MyThread7_2 {
    /**
     * 共享对象，实际上并不需要使用此处创建的object
     * 只是需要对object加锁，以此来控制线程的交替
     */
    private static final Object object = new Object();
    static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            //加锁，锁住的是对象
            synchronized(object) {
                for (int i = 1; i <= 10; i++) {
                    //用while来wait，防止虚假唤醒
                    while (!flag) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println(Thread.currentThread().getName() + "\t" + 'a');

                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //A任务完成，通知B线程输出b
                    flag = false;
                    object.notify();
                }
            }

        }, "A");

        Thread t2 = new Thread(() -> {
            //加锁，锁住的是对象
            synchronized(object) {
                for (int i = 1; i <= 10; i++) {
                    while (flag) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + "\t" + 'b');
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //B任务完成，通知A线程输出a
                    flag = true;
                    object.notify();
                }
            }

        }, "B");

        t1.start();
        t2.start();

    }
}
