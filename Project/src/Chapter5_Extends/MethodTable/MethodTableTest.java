package Chapter5_Extends.MethodTable;

import java.lang.reflect.Method;

public class MethodTableTest
{
    public static void main(String[] args) throws Exception
    {
        // 获得square 和 sqrt 的方法指针
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);

        // 制表
        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
    }

   public static double square(double x)
    {
        return x * x;
    }

    private static void printTable(double from, double to, int n, Method f)
    {
        //打印方法作为表头
        System.out.println(f);

        double dx = (to - from) / (n - 1);

        for (double x = from; x <= to; x += dx)
        {
            try
            {
                /**
                 * invoke方法，允许调用包装在当前method对象中的方法
                 */
                double y = (Double) f.invoke(null, x);
                System.out.printf("%10.4f | %10.4f%n", x, y);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
