package MyThread.CreateThread;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/13
 *
 * 通过继承Thread类并重写run方法来创建线程
 */
public class ExtendsThread {
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("MyThread run");
        }
    }
    public static void main(String[]args){
        MyThread thread=new MyThread();

        thread.start();
    }
}
