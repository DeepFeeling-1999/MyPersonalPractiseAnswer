package A.p8;

import java.util.concurrent.TimeUnit;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/10
 *
 * 先输出完a后输出b
 * 使用Object的join函数，等待线程完成
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


        //t1启动
        t1.start();
        //等待t1完成
        t1.join();

        //此时t1已经完成，t2运行
        t2.start();
    }
}
