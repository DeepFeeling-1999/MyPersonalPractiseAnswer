package MyThread.CAS.LongAdder;

import java.util.concurrent.atomic.LongAccumulator;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/17
 */
public class LongAccumulatorTest {
    private static LongAccumulator longAccumulator = new LongAccumulator((x, y) -> x * y, 1);

    private static Integer[] arrayOne = new Integer[]{0, 1, 2, 0, 4, 5, 0, -9, 0, -8};
    private static Integer[] arrayTwo = new Integer[]{0, 1, 2, 0, 4, 0, 0, -9, 0, -8};

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            int size = arrayOne.length;
            for (int i = 0; i < size; ++i) {
                if (arrayOne[i].intValue() == 0) {
                    longAccumulator.accumulate(2);
                }
            }
        });
        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < arrayTwo.length; ++i) {
                if (arrayTwo[i].intValue() == 0) {
                    longAccumulator.accumulate(2);
                }
            }
        });
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();

        System.out.println("count 0: " + longAccumulator.getThenReset());

    }
}
