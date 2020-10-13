package Thread.CallableDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyThread implements Runnable{
    @Override
    public void run() {

    }
}

/**
 * 只有一个方法，是函数式接口，可以用lambda表达式
 */
class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        try{
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"call 方法");

        return 1024;
    }
}

/**
 *get 方法一般放在最后一行，可以让其他线程先执行
 *
 * FutureTask 只有一个对象，调用多次会进行缓存
 * 所以只会实际使用一次
 */
public class TestDemo {
    public static void main(String[]args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask=new FutureTask(new MyCallable());

        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        System.out.println(Thread.currentThread().getName()+"+ 完成");
        /**
         * V get():获取结果，如果这个计算任务还没有执行结束，该调用线程会进入阻塞状态。
         */
        Integer result=futureTask.get();


    }
}
