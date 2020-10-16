package MyThread.ThreadLocalTest;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/14
 *
 * InheritableThreadLocal类通过重写get和create方法
 * 让本地变量保存到了具体线程的inheritableThreadLocals变量中
 * 然后当父线程创建子线程时，构造函数会把inheritableThreadLocals
 * 里的本地变量保存一份到子线程的inheritableThreadLocals中
 *
 * 场景：子线程需要使用存放在threadLocal变量中的用户登录信息，
 * 或者一些中间件需要把同一的id调用链路记录下来
 */
public class InheritableThreadLocalTest {
    static InheritableThreadLocal<String> local = new InheritableThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        local.set("one");
        Thread threadOne = new Thread(() -> {
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
