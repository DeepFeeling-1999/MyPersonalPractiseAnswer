package A;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/13
 */
public class aaa {
    public static void main(String[] args) {
        Thread threadB = new Thread(() -> {
            System.out.println("ThreadOne begin run");
        });

        threadB.isInterrupted();

        final Thread mainThread = Thread.currentThread();

    }
}
