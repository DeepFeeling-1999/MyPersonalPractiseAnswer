package MyThread.ReadWriteLock.CopyOnWriteArrayList;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/17
 *
 * CopyOnWriteArrayList使用写时复制来保证list的一致性
 * 增删改中使用独占锁ReentrantLock来保证只有一个线程能修改list
 *
 * 但是在get时，由于是先获取数组，再get，没有加锁，中间如果别的线程进行remove操作的话
 * 会导致get操作任然读取到被删除的值，因为remove是复制一份，然后在复制的那份上删除，然后重新指向
 *
 * 且提供了弱一致性的迭代器，获取迭代器后，别的线程的修改是不可见的
 * 因为迭代器遍历的是一个快照
 * 在获取元素的时候没有加锁，也就可能因为别的线程删除了元素但是还是获取到了的弱一致性问题
 */
public class CopyOnWriteArrayListTest {
    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList();

    public static void main(String[] args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("alibaba");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("hangzhou");

        Thread threadOne=new Thread(()->{
            arrayList.set(1,"baba");

            arrayList.remove(2);
            arrayList.remove(3);
        });

        //在线程启动前获取迭代器
        Iterator<String> iterator=arrayList.iterator();

        threadOne.start();
        threadOne.join();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
