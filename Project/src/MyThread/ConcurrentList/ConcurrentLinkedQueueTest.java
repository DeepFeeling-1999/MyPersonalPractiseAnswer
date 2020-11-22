package MyThread.ConcurrentList;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/21
 *
 * 线程安全的无界非阻塞队列，底层使用单向链表实现，
 * 出队入队使用CAS来实现线程安全
 *
 * 通过CAS操作来控制某时只有一个线程可以添加元素到队尾，
 * CAS竞争失败的会通过循环自旋来不断尝试
 */
public class ConcurrentLinkedQueueTest {}
