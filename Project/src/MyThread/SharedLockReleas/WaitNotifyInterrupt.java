package MyThread.SharedLockReleas;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/13
 *
 * 当线程调用共享对象的wait阻塞挂起后，
 * 如果被其他线程中断，则会抛出InterruptedException
 */
public class WaitNotifyInterrupt {
    static Object object=new Object();
    public static void main(String[]args) throws InterruptedException {
        Thread threadA=new Thread(()->{
            try{
                System.out.println("开始，阻塞当前线程");
                synchronized(object){
                    object.wait();
                }
                System.out.println("结束，当前线程完成");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        Thread.sleep(1000);

        System.out.println("打断线程");
        threadA.interrupt();
        System.out.println("打断完成");
    }
}
