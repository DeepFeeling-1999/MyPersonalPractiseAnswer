package MyThread.DeadLock;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/14
 */
public class DeadLockTest1 {
    private static Object resourcesA=new Object();
    private static Object resourcesB=new Object();

    public static void main(String[]args) throws InterruptedException {
        Thread threadA=new Thread(()->{
            synchronized(resourcesA){
                System.out.println(Thread.currentThread()+" 获取到sourcesA");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread()+" 尝试获取sourcesB");

                synchronized(resourcesB){
                    System.out.println(Thread.currentThread()+" 获取到资源B");
                }
            }
        });

        Thread threadB=new Thread(()->{
            synchronized(resourcesB){
                System.out.println(Thread.currentThread()+" 获取到sourcesB");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread()+" 尝试获取sourcesB");

                synchronized(resourcesA){
                    System.out.println(Thread.currentThread()+" 获取到资源A");
                }
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
    }

}
