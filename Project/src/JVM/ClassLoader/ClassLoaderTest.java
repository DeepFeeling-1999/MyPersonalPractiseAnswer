package JVM.ClassLoader;

/**
 * 三种加载器
 * 启动类
 * 扩展类加载器
 * 应用程序加载器，也叫作系统类加载器，加载目录下所有类
 *
 * 自定义加载器
 *
 */
public class ClassLoaderTest {
    public static void main(String[]args){
        Object object=new Object();
        System.out.println(object.getClass().getClassLoader());

        ClassLoaderTest t=new ClassLoaderTest();
        System.out.println(t.getClass().getClassLoader().getParent().getParent());
        System.out.println(t.getClass().getClassLoader().getParent());
        System.out.println(t.getClass().getClassLoader());

    }
}
