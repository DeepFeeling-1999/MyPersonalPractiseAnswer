package CoreJava.Chapter6_Interface.InnerClass.StaticInnerClass;

/**
 * 其余注释见后面
 * <p>
 * 静态内部类不支持外部类对象引用
 * 如果局部变量的值在编译期间就可以确定，则直接在匿名内部里面创建一个拷贝。
 * 如果局部变量的值无法在编译期间确定，则通过构造器传参的方式来对拷贝进行初始化赋值。
 * <p>
 * java编译器就限定必须将变量a限制为final变量，
 * 不允许对变量a进行更改（对于引用类型的变量，是不允许指向新的对象），
 * 这样数据不一致性的问题就得以解决了。
 * <p>
 * 局部内部类和匿名内部类只能访问局部final变量
 * <p>
 * 对于成员内部类，必须先产生外部类的实例化对象，才能产生内部类的实例化对象。
 * 而静态内部类不用产生外部类的实例化对象即可产生内部类的实例化对象。
 */
public class StaticInnerClass {

    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++)
            d[i] = 100 * Math.random();

        ArrayAlg.Pair p = ArrayAlg.minmax(d);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }
}

class ArrayAlg {
    /**
     * 静态内部类，不可以引用其他非静态的对象
     */
    public static class Pair {
        private double first;
        private double second;

        public Pair(double f, double s) {
            first = f;
            second = s;
        }

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            new test();
            return second;
        }
    }

    public static class test {

    }

    /**
     * 静态方法里面必须使用静态内部类，
     * 这是由于内部类对象是在静态方法中构造的
     */
    public static Pair minmax(double[] values) {
        double min = Double.POSITIVE_INFINITY;
        double max = Double.NEGATIVE_INFINITY;
        for (double v : values) {
            if (min > v) {
                min = v;
            }
            if (max < v) {
                max = v;
            }
        } return new Pair(min, max);
    }
}

