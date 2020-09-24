package Thread.myBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class test {
    public static void main(String[]args) throws InterruptedException {
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);


        ///**
        // *  添加错误的时候异常
        // */
        //System.out.println(blockingQueue.add("a"));
        //System.out.println(blockingQueue.add("b"));
        //System.out.println(blockingQueue.remove());
        //
        ///**
        // * 添加错误的时候offer报false，poll报null
        // */
        //System.out.println(blockingQueue.offer("a"));
        //System.out.println(blockingQueue.offer("b"));
        //System.out.println(blockingQueue.poll());

        ///**
        // * put和take会进行阻塞
        // */
        //blockingQueue.put("a");
        //blockingQueue.put("a");
        //blockingQueue.put("a");
        //blockingQueue.put("a");
        //System.out.println(blockingQueue.take());

        /**
         * 超时退出
         */
        blockingQueue.offer("A");
        blockingQueue.offer("A");
        blockingQueue.offer("A");
        System.out.println("添加三个后，继续添加，阻塞超过三秒则退出 ");
        blockingQueue.offer("A", 3, TimeUnit.SECONDS);






    }
}
