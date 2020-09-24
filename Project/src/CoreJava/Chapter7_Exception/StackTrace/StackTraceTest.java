package CoreJava.Chapter7_Exception.StackTrace;

import java.util.Scanner;

public class StackTraceTest {
    /**
     * Computes the factorial of a number
     *
     * @param n a non-negative integer
     * @return n! = 1 * 2 * . . . * n
     */
    public static int factorial(int n) {
        System.out.println("factorial(" + n + "):");

        Throwable t = new Throwable();

        //Throwable类的printStackTrace方法，会得到StackTraceElement对象的一个数组
        //然后可用于分析
        StackTraceElement[] frames = t.getStackTrace();

        for (StackTraceElement f : frames)
            System.out.println(f);

        int r;
        if (n <= 1) {
            r = 1;
        } else {
            r = n * factorial(n - 1);
        }
        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();

        factorial(n);
    }
}
