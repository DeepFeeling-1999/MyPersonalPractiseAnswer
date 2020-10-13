package A.p8;

import java.util.concurrent.TimeUnit;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/10
 */
public class MyThread7_2 {
    private static final Object object=new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized(object){
                for (int i = 1; i <= 10; i++) {
                    object.notify();
                    try {
                        System.out.println(Thread.currentThread().getName() + "\t" + 'a');
                        TimeUnit.MILLISECONDS.sleep(100);
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }, "A");

        Thread t2 = new Thread(() -> {
            synchronized(object){
                for (int i = 1; i <= 10; i++) {
                    object.notify();
                    try {
                        System.out.println(Thread.currentThread().getName() + "\t" + 'b');
                        TimeUnit.MILLISECONDS.sleep(200);
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }, "B");


        t1.start();
        t2.start();

    }
}
