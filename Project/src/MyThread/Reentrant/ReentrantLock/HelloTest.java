package MyThread.Reentrant.ReentrantLock;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/16
 *
 * 可重入锁，即只要改线程获取了该锁，就可以无限的进入被锁住的代码
 * synchronized内部是可重入锁
 *
 * 可重入锁的原理是在锁内部维护一个线程标识
 * 标识哪个线程获取了锁，然后关联一个计数器
 * 当获取了该锁的线程再次获取锁时发现锁拥有者是自己，就会把计数器值再加+1，当释放锁后计数器值-1
 * 计数器为0时会释放锁
 */
public class HelloTest {
    public synchronized void helloA(){
        System.out.println("helloA");
    }
    public synchronized void helloB(){
        System.out.println("helloB");
        helloA();
    }

    public static void main(String[]args){
        new HelloTest().helloB();
    }
}
