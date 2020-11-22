package MyThread.ConcurrentList;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/21
 *
 * 内部有一个数组items，用来存放队列元素
 * 访问这些变量都是在锁内，加锁保证内存可见性
 * 有个独占锁lock保证入队出队的原子性，保证一个时刻只有一个线程可以入队出队
 * notEmpty、notFull条件变量用来进行出、入队的同步。
 */
public class ArrayBlockingQueueTest {

}
