package MyThread.Daemon;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/14
 *
 * 可以通过setDaemon(true)来设置为守护线程，默认是用户线程
 * 非守护线程（用户线程）退出时，不管是否有守护线程
 * JVM都会正常退出
 * 也就是只要有一个用户线程还没有结束，JVM就不会退出
 */
public class SetDaemon {
    public static void main(String[]args){
        Thread threadOne=new Thread(()->{
            while(true){

            }
        });

        threadOne.setDaemon(true);
        threadOne.start();
        System.out.println("main over ");
    }

}
