package MyThread.ThreadJoin;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/13
 *
 * 调用join方法进行阻塞，等待执行完成后返回
 * 此例中线程一二都join阻塞，是并行的，并不是先一后二
 */
public class JoinTest {
    public static void main(String[]args) throws InterruptedException {
        Thread threadOne=new Thread(()->{
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程一完成");
        });

        Thread threadTwo=new Thread(()->{
            //try{
            //    Thread.sleep(1000);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
            System.out.println("线程二完成");
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();
    }
}
