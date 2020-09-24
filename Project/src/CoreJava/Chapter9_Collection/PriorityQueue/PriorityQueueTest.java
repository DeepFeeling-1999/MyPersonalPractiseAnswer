package CoreJava.Chapter9_Collection.PriorityQueue;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * 优先队列
 * priority  优先
 * <p>
 * 用堆实现，即可自我调节的二叉树
 * 可以任意顺序插入，但是调用remove总是会获得最小的元素
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<LocalDate> test = new PriorityQueue<>();

        test.add(LocalDate.of(3333, 3, 3));
        test.add(LocalDate.of(4444, 4, 4));
        test.add(LocalDate.of(1111, 1, 1));
        test.add(LocalDate.of(2222, 2, 2));

        //在元素上迭代
        System.out.println("Iterating over elements...");
        for (LocalDate temp_Date : test) {
            System.out.println(temp_Date);
        }

        //移出元素
        while (!test.isEmpty()) System.out.println(test.remove());

    }
}

