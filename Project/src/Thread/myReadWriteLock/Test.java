package Thread.myReadWriteLock;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{
    private volatile Map<String,Object> myMap=new HashMap<>();
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

    public void put(String key,Object value) throws InterruptedException {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t写入数据" + key);
            TimeUnit.MILLISECONDS.sleep(300);

            myMap.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t写入完成" + key);
        } catch (Exception e) {

        }finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t读取数据" + key);
            Object result = myMap.get(key);
            System.out.println(Thread.currentThread().getName() + "\t读取完成" + key);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
}
public class Test {
    public static void main(String[]args){
        MyCache myCache=new MyCache();

        for (int i=1;i<=5;i++){
            final int temp=i;

            new Thread(()->{
                try {
                    myCache.put(String.valueOf(temp), temp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

        for (int i=1;i<=5;i++){
            final int temp=i;

            new Thread(()->{
                myCache.get(String.valueOf(temp));
            }, String.valueOf(i)).start();
        }
    }
}
