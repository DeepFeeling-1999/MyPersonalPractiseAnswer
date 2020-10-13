package MyThread.CreateThread;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/13
 */
public class ImplementsRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("ImplementsRunnable run");
    }

    public static void main(String[]args){
        ImplementsRunnable task=new ImplementsRunnable();

        new Thread(task).start();
        new Thread(task).start();

    }
}
