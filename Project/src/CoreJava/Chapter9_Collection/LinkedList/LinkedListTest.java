package CoreJava.Chapter9_Collection.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 链表
 * Java中都是双向链表
 * 注意add方法只依赖于迭代器的位置，而remove方法依赖于迭代器的状态
 * 即remove方法删除迭代器返回的元素
 * 调用next或previous之后调用remove，会删除不同位置的元素
 * <p>
 * Collection接口有两个基本方法，boolean add(E element); Iterator<E> iterator();
 * <p>
 * Iterator 接口有四个方法 E next(); boolean hasNext(); void remove();
 * default void forEachRemaining(Consumer<? super E> action);
 */
public class LinkedListTest {
    public static void main(String[] args) {
        //List是一个有序集合，元素会增加到容器中特定的位置，可以迭代器或者索引访问
        List<String> a = new LinkedList<>();
        a.add("c");
        a.add("c");
        a.add("d");
        a.add("a");
        a.add("c");
        a.add("c");

        List<String> b = new LinkedList<>();
        b.add("b1");
        b.add("b2");
        b.add("b3");
        b.add("b4");
        b.add("b5");
        b.add("b6");

        //返回一个列表迭代器，用来访问列表中的元素
        ListIterator<String> aIterator = a.listIterator();

        //返回一个用于访问集合中每个元素的迭代器
        Iterator<String> bIterator = b.iterator();

        //将b合并到a中
        while (bIterator.hasNext())       //b不为空
        {
            if (aIterator.hasNext())      //同时a不为空，移一位
            {
                aIterator.next();
            }

            //合并
            aIterator.add(bIterator.next());
        }

        //调用AbstractCollection类中的toString方法打印出链表a中的所有元素
        System.out.println(a);

        //重新指向
        bIterator = b.iterator();
        //隔一个删除元素
        while (bIterator.hasNext()) {
            bIterator.next();
            if (bIterator.hasNext()) {
                bIterator.next();
                bIterator.remove();
            }
        }

        System.out.println(b);

        //批量操作，从a中删除b
        a.removeAll(b);

        System.out.println(a);
    }
}

