package MyThread.ThreadLocalTest;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/14
 *
 * 同一个ThreadLocal变量在父线程被设置后，在子线程应该是访问不到的
 * main线程下的子线程设置，main也访问不到
 * 因为调用set的是ThreadOne线程，get的是ThreadTwo和main，不是同一个
 */
public class ExtendsThreadLocal {
    static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            local.set("one");
            System.out.println("threadOne " + local.get());
            Thread threadTwo = new Thread(() -> {
                System.out.println("threadTwo " + local.get());
            });
            threadTwo.start();
        });

        threadOne.start();
        threadOne.join();

        System.out.println("main " + local.get());


    }
}
