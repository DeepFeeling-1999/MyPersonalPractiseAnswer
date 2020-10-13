package Jvm.NotInitialization;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/12
 */
public class SubClass extends SuperClass{
    static{
        System.out.println("SuperClass init");
    }
}
