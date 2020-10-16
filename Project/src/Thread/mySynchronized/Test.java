package Thread.mySynchronized;

import java.util.concurrent.TimeUnit;

/**
 * 只要在一个资源类里，不管有多少个synchronized方法
 * 在某个时刻只要有一个线程去访问了这些synchronized方法，
 * 锁的是当前资源类对象this（对象），被锁定后，其他线程都不能进入当前这个对象的其他synchronized方法
 *
 * 普通方法不影响
 *
 * 对于同步方法块，锁的是Synchronized括号里配置的对象或类
 * 只有方法快会被锁，方法外不会锁
 *
 * * static同步方法锁的是class（类），别的对象访问静态同步方法也会被锁
 *
 * 静态同步方法和非静态同步方法之间不会有竞争
 */

class Phone {
    private int amount=0;

    public static synchronized void sendEmail() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread().getName() + "\temail");
    }

    public static synchronized void sendMessage() {
        System.out.println(Thread.currentThread().getName() + "\tmessage");
    }

    public synchronized void say() {
        System.out.println(Thread.currentThread().getName() + "\t普通同步方法");
    }

    public void sayHello() {
        System.out.println(Thread.currentThread().getName() + "\thello");
    }

    public void sayBlock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "\thello");
        synchronized(this){
            TimeUnit.SECONDS.sleep(2);
            for(int i=1;i<=3;i++){
                ++amount;
            }
            System.out.println(Thread.currentThread().getName() + "\t"+amount);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try {
                phone1.sayBlock();
                //Phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                phone1.sayBlock();
                //phone1.sayHello();
                //Phone.sendMessage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "b").start();

    }
}
