package Jvm.NotInitialization;

/**
 * 读取或设置一个类型的静态字段（被final修饰、已在编译期把结果放入常量池的静态字段除外）的时候
 * 会进行初始化
 */
class temp {
    static {
        System.out.println("Const Class init!");
    }

    /**
     * 此处加final会在编译器直接优化进ConstClass常量池中，
     * 不会进行temp类初始化
     */
    public static final String HELLOWORLD = "hello world";
}

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/12
 */
public class ConstClass {
    public static void main(String[]args){
        System.out.println(temp.HELLOWORLD);
    }
}

