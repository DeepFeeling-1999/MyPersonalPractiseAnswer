package Thread.SemaphoreDemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * Semaphore也是一个线程同步的辅助类，可以维护当前访问自身的线程个数，并提供了同步机制
 */
public class test {
    public static void main(String[]args){

        // 模拟资源类有三个空车位
        Semaphore semaphore=new Semaphore(3);

        for(int i=1;i<=6;i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到了");

                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"\t 离开了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放资源
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }

    }
}
