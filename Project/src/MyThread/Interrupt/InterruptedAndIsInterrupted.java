package MyThread.Interrupt;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/13
 */
public class InterruptedAndIsInterrupted {
    public static void main(String[]args) throws InterruptedException {

        Thread threadOne=new Thread(()->{
            while(true){
            }
        });

        threadOne.start();

        //设置中断标志
        threadOne.interrupt();

        //获取中断标志
        System.out.println("isInterrupted: "+threadOne.isInterrupted());

        //获取中断标志并重置
        System.out.println("isInterrupted: "+ Thread.interrupted());
        //获取中断标志并重置
        System.out.println("isInterrupted: "+ Thread.interrupted());
        //获取中断标志
        System.out.println("isInterrupted: "+threadOne.isInterrupted());

        threadOne.join();
        System.out.println("main over");


    }
}
