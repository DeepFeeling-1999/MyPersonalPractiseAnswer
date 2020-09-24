package Thread.SaleTicket;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 1故障现象
 * java.util.ConcurrentModificationException
 * 2导致原因
 * <p>
 * 3解决办法
 * 3.1 new Vecto<>()
 * 3.2 Collections.synchronizedList(new ArrayList<>())
 * <p>
 * 4优化建议
 */
public class NoSafeDemo3 {
    public static void main(String[] args) {

        Map<String,String> myMap=new ConcurrentHashMap<>();
        for (int i=1;i<=40;i++){
            new Thread(()->{
                myMap.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,5));
                System.out.println(myMap);
            },String.valueOf(i)).start();
        }
    }

    public static void setNotSafe(){
        Set<String> mySet = new CopyOnWriteArraySet<>();
        for (int i=1;i<=40;i++){
            new Thread(()->{
                mySet.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(mySet);
            },String.valueOf(i)).start();
        }

    }
    public static void listNotSafe() {
        /**
         * 线程不安全，没有加锁，vector线程安全，但是更慢
         */
        List<String> myList = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                myList.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(myList);
            }, String.valueOf(i)).start();
        }

        ///**
        // * 消费型函数
        // */
        //myList.forEach(System.out::println);
    }
}
