package MyThread.Yield;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/13
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

        new YieldTest();

    }
}
