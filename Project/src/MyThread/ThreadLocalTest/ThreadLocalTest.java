package MyThread.ThreadLocalTest;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/14
 *
 * 创建一个ThreadLocal 访问的时候是每个线程都会有一个线程本地副本，不是共享的
 * ThreadLocal里的value值是存放到调用线程内部的成员threadLocals里存放起来的，
 * 只是通过ThreadLocal的get方法来获取
 *
 * threadLocals是map结构，用来存储对应线程和值的映射关系
 *
 */
public class ThreadLocalTest {
    static void print(String string){
        //打印当前线程本地内存中的localVariable变量的值
        System.out.println(string+": "+local.get());

        //local.remove();
    }

    static ThreadLocal<String> local=new ThreadLocal<>();

    public static void main(String[]args) throws InterruptedException {
        Thread threadOne=new Thread(()->{
            local.set("ThreadLocal One variable");
            print("threadOne ");
            //System.out.println("threadOne remove after :"+local.get());
        });

        Thread threadTwo=new Thread(()->{
            //local.set("ThreadLocal Two variable");
            print("threadTwo ");
            //System.out.println("threadTwo remove after :"+local.get());
        });

        threadOne.start();
        threadOne.join();
        threadTwo.start();

    }
}
