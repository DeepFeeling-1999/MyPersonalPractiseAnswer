package MyThread.CreateThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/13
 *
 * 可获取返回值
 */
public class MyCallerTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "CallTask call";
    }

    public static void main(String[]args){
        FutureTask<String> futureTask=new FutureTask<>(new MyCallerTask());

        new Thread(futureTask).start();
        try{
            String result=futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
