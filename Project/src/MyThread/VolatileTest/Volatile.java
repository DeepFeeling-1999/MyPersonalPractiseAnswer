package MyThread.VolatileTest;

/**
 * @author Deep-Feeling-1999
 * @create 2020/10/15
 *
 * volatile可以解决内存可见性问题，即内存的更新都保证可见
 *
 * 并且可可以避免重排序问题，指令重排序指不存在数据依赖性的指令重排序以提高性能
 *
 * 加volatile可以保证写volatile变量之前的操作不会被
 * 编译器重排序到写之后
 * 读之后的操作不会被编译器重排序到读之前
 */
public class Volatile {}
