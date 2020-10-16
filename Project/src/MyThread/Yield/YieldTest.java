package MyThread.Yield;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/13
 *
 * 通知CPU当前线程放弃剩余时间片，并没有被阻塞，而是出于就绪状态，
 * 表示现在就可以进行线程调度
 * 线程调度器会从线程就绪队列里获取优先级最高的线程，
 * 也可能会调度到当前线程
 */
public class YieldTest implements Runnable {
    public YieldTest() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            if((i%5)==0){
                System.out.println(Thread.currentThread()+"yield cpu");

                //放弃剩余时间片，进行下一轮调度
                Thread.yield();
            }
            System.out.println(Thread.currentThread()+" is over");
        }
    }

    public static void main(String[]args){
        new YieldTest();
        new YieldTest();

        Map<String,String> map=new HashMap<>(5);
        new YieldTest();

    }
}
