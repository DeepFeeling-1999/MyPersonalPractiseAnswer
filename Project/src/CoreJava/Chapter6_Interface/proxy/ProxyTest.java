package CoreJava.Chapter6_Interface.proxy;

import java.lang.reflect.*;
import java.util.*;

/**
 * 代理可以在运行时创建一个实现了一组给定接口的新类
 * 只有在编译时无法确定需要实现哪个接口时才有必要使用
 * <p>
 * 具有指定接口所需的全部方法，Object类中的全部方法，如toString，equals等
 * 需要提供一个调用处理器（是指实现了InvocationHandler接口的类对象，
 * 这个接口中只有一个方法 Object  invoke（Object proxy，Method method，Object[]args）
 */
public class ProxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[2];

        // 填充元素
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;

            //创建一个   "调用处理器"
            InvocationHandler handler = new TraceHandler(value);

            /**
             * 创建一个代理对象
             * @param   null 表示默认的类加载器,
             * Class对象的数组，每个元素都是需要实现的接口
             * 一个"调用处理器"
             */
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        // 构造一个随机整数
        Integer key = new Random().nextInt(elements.length) + 1;

        // search for the key
        int result = Arrays.binarySearch(elements, key);

        // print match if found
        if (result >= 0) {
            System.out.println(elements[result]);
        }
    }
}

/**
 * 输出方法名和参数的调用处理器，然后
 * 调用原始方法
 */
class TraceHandler implements InvocationHandler {
    private Object target;

    public TraceHandler(Object t) {
        target = t;
    }

    /**
     * 无论何时调用代理对象的方法，调用处理器的invoke方法都会被调用
     *
     * @param proxy 代理对象
     * @param m     方法
     * @param args  对象数组
     * @return 返回一个对象
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        // 打印隐式参数
        System.out.print(target);
        //打印类名
        System.out.print("    .     " + m.getName() + "(");

        // 打印显式参数
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length - 1) {
                    System.out.print(", ");
                }
            }
        }

        System.out.println(")");

        // 调用实际方法
        return m.invoke(target, args);
    }
}