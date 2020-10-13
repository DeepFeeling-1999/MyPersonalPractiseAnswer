package Jvm.NotInitialization;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/12
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init");
    }

    public static int value = 123;
}
