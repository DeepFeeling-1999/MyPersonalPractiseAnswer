package CoreJava.Chapter9_Collection.TreeSet;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 树集
 * 是有序集合，
 * 要实现树集，必须能够比较元素，元素必须实现Comparable接口。
 * 或者构造树集的时候提供一个Comparator比较器
 *
 * SortedSet接口
 * 提供排序操作，以及更多集合的方法
 */

public class TreeSetTest
{
    public static void main(String[] args)
    {
        //TreeSet 树集实现了 SortedSet接口
        SortedSet<Item> parts=new TreeSet<>();

        parts.add(new Item("aaa",111));
        parts.add(new Item("bbb",222));
        parts.add(new Item("ccc",333));
        parts.add(new Item("ddd",444));

        //调用toString方法
        System.out.println(parts);

        //TreeSet类实现了NavigableSet接口，此接口增加了几个便于定位以及反向遍历的方法
        NavigableSet<Item>sortByDescription=
                new TreeSet<>(Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
