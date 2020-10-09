package Test.Static;

/**
 * 在执行开始，先要寻找到main方法，因为main方法是程序的入口，
 * <p>
 * 但是在执行main方法之前，必须先加载StaticTest类，
 * <p>
 * 而在加载StaticTest类的时候发现StaticTest类继承自Base类，
 * 因此会转去先加载Base类，在加载Base类的时候，
 * 发现有static块，便执行了static块。
 * 在Base类加载完成之后，便继续加载StaticTest类，
 * 然后发现StaticTest类中也有static块，便执行static块。
 * 在加载完所需的类之后，便开始执行main方法。
 * 在main方法中执行new StaticTest()的时候会先调用父类的构造器，然后再调用自身的构造器。
 */
public class StaticTest extends Base {

    static {
        System.out.println("t3 static");
    }

    public StaticTest() {
        System.out.println("t3 constructor");
    }

    public static void main(String[] args) {
        new StaticTest();
    }
}

class Base {

    static {
        System.out.println("base static");
    }

    public Base() {
        System.out.println("base constructor");
    }
}
