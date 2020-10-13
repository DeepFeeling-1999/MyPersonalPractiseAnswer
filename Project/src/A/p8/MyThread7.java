package A.p8;

import java.util.concurrent.TimeUnit;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/10
 */
public class MyThread7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + 'a');
            }
        }, "A");

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "\t" + 'b');
            }
        }, "B");


        //********先a后b
        t1.start();
        t1.join();

        t2.start();

    }
}
