package MyThread.Interrupt;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/13
 *
 * boolean interrupted()方法是Thread类的静态方法，可以直接通过类访问
 * 会检测当前线程是否被中断，是true，否false
 * 而且会清除中断标志，将中断标志从true改为false
 *
 * boolean isInterrupted()方法是检测当前线程是否被中断
 * 是true，否false，不会清除中断标志
 */
public class InterruptedAndIsInterrupted2 {
    public static void main(String[]args) throws InterruptedException {
        Thread threadOne=new Thread(()->{
            while(!Thread.interrupted()){

            }
            System.out.println("ThreadOne isInterrupted: "+Thread.currentThread().isInterrupted());
        });

        threadOne.start();
        threadOne.interrupt();
        threadOne.join();
        System.out.println("main over");
    }
}
