package Thread.myThreadPool;

import java.util.concurrent.*;

/**
 * @author Deep-Feeling-1999
 *自定义线程池有七个参数
 * 核心线程数（常驻数目）
 * 最大线程数
 *
 * 多余线程（超过核心数（扩容的））超时回收时间
 * 超时回收时间格式
 *
 * 阻塞队列
 * 拒绝规则
 *
 *
 *
 *
 * 这自带的三个都不用，因为默认容量很大，容易造成oom（内存溢出）
 * 固定数线程
 * Executors.newFixedThreadPool(5);
 *
 * 单例
 * Executors.newSingleThreadExecutor();
 *
 * 无限扩大，适用于负载较轻的场景
 * Executors.newCachedThreadPool();
 */
public class Test {
    public static void main(String[]args){

        ExecutorService threadPool= new ThreadPoolExecutor(
                2,
                5,
                3L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        try{
            for (int i=1;i<=20;i++){
                int finalI = i;
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+ "\t"+finalI);
                    try {
                        TimeUnit.MILLISECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
