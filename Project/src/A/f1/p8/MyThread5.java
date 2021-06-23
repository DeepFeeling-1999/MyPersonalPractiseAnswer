package A.f1.p8;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/10
 *
 *  //构造四个线程，并启动
 *  此时是无序输出
 */
public class MyThread5 {
    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 10; i <= 19; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 20; i <= 29; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 30; i <= 39; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 40; i <= 49; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
        }, "D").start();
    }
}
