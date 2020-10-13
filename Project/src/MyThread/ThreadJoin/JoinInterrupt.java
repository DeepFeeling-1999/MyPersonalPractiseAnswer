package MyThread.ThreadJoin;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/13
 *
 * 线程A调用线程B的join方法后会被阻塞，当别的线程调用线程A的interrupt方法
 * 中断了线程A时，线程A会被抛出InterruptException异常
 */
public class JoinInterrupt {
    public static void main(String[]args){
        Thread threadB=new Thread(()->{
            System.out.println("ThreadOne begin run");
            while(true){
            }
        });

        //获取主线程
        final Thread mainThread=Thread.currentThread();

        Thread threadA=new Thread(()->{
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mainThread.interrupt();
        });

        threadA.start();
        threadB.start();

        //等待ThreadOne执行结束
        try{
            threadB.join();
        } catch (InterruptedException e) {
            System.out.println("main thread: "+e);
        }
    }
}
