package MyThread.ConcurrentList;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/21
 *
 * LinkedBlockingQueue也是使用单向链表实现
 * 有两个Node，有初始值为0的count变量，用来记录元素个数
 * 还有两个ReentrantLock实例，分别用来控制元素出入队
 *
 * 还有两个条件变量（Condition）notEmpty和notFull
 * 如当队列为空时，执行出队操作的线程会被放入条件队列中进行等待
 * 由入队出队操作的条件队列存放阻塞来实现生产消费模型
 */
public class LinkedBlockingQueueTest {
    public static void main(String[]args){

    }
}
