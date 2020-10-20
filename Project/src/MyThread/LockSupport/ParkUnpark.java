package MyThread.LockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/17
 *
 * LockSupport是个工具类，主要作用是唤醒和挂起线程，是创建锁和同步类的基础
 *
 * 调用park方法的线程如果已经拿到许可证，则马上返回，否则会被禁止参与线程调度（阻塞挂起）
 * 默认是不持有许可证的
 *
 * 其他线程调用unpark会让参数线程获得许可证，如果之前被park挂起，则会被唤醒
 * 如果之前没有调用park，则调用unpark方法后会立刻返回
 */
public class ParkUnpark {
    public static void main(String[]args) throws InterruptedException {
        System.out.println("begin park!");
        LockSupport.unpark(Thread.currentThread());

        LockSupport.park();
        System.out.println("end park!");

        System.out.println("***********************");

        Thread threadOne=new Thread(()->{
            System.out.println("child thread begin park!");

            //只有被中断退出才会退出循环
            //while(!Thread.currentThread().isInterrupted()) {
                LockSupport.park();
            //}
            System.out.println("chile thread unpark");
        });

        threadOne.start();
        Thread.sleep(1000);
        System.out.println("main thread begin unpark");

        //在main线程里调用unpark方法让threadOne线程获得许可证，然后让park方法返回
        LockSupport.unpark(threadOne);
    }
}
