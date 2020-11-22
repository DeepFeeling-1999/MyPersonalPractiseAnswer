package MyThread.StampedLockTest;

import java.util.concurrent.locks.StampedLock;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/21
 */
public class Point {
    private double x, y;
    /**
     * 创建锁实例
     */
    private final StampedLock stampedLock = new StampedLock();

    public void move(double deltaX, double deltaY) {
        //排它锁，写锁
        long stamp = stampedLock.writeLock();
        try {
            y += deltaY;
            x += deltaX;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public double distanceFromOrigin() {
        //尝试获取乐观锁
        long stamp = stampedLock.tryOptimisticRead();
        //将变量复制到方法体栈内
        double currentX = x, currentY = y;
        //检查获取的读锁戳记后，锁没有被抢占
        if (!stampedLock.validate(stamp)) {
            //如果被抢占，则获取一个悲观共享读锁
            stamp = stampedLock.readLock();
            try {
                //复制到方法体栈
                currentX = x;
                currentY = y;
            } finally {
                //释放共享读锁
                stampedLock.unlockRead(stamp);
            }
        }
        //计算
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    public void moveIfAtOrigin(double newX, double newY) {
        //先使用乐观读锁
        long stamp = stampedLock.readLock();

        try {
            //如果当前点在原点则移动
            while (x == 0.0 && y == 0.0) {
                //尝试将获取的读锁升级为写锁
                long ws = stampedLock.tryConvertToWriteLock(stamp);
                if (ws != 0L) {
                    //升级成功则更新戳记，并设置坐标
                    stamp = ws;
                    x = newX;
                    y = newY;
                } else {
                    //升级失败则释放读锁，显式获取独占写锁，然后循环重试
                    stampedLock.unlockRead(stamp);
                    stamp = stampedLock.writeLock();
                }
            }
        } finally {
            //释放锁
            stampedLock.unlock(stamp);
        }
    }

}
