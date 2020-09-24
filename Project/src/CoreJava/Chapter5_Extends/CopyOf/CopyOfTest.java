package CoreJava.Chapter5_Extends.CopyOf;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));

        // b = (String[]) badCopyOf(b, 10);
        //故Object数组不能转换成String
    }

    private static Object[] badCopyOf(Object[] a, int newLength) // 会抛出转换异常
    {
        Object[] newArray = new Object[newLength];
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
        //Java数组会记住每个元素的类型，可以将Employee数组临时转换成Object数组，然后再转回来
        //但是不能将Object数组转换成Employee数组
    }

    private static Object goodCopyOf(Object a, int newLength)
    //参数为Object不是Object[]，因为整型数组类型可以转换成Object
    //重点是通过反射获取要复制的对象信息
    {
        Class cl = a.getClass();
        //如果不是数组
        if (!cl.isArray()) {
            return null;
        }

        Class componentType = cl.getComponentType();
        //getComponentType返回数组元素对应的class对象
        int length = Array.getLength(a);

        Object newArray = Array.newInstance(componentType, newLength);
        /**
         * Array类中的静态方法newInstance，构造新数组
         *@param ，元素类型，数组长度
         */

        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        /**
         * 浅复制，即若是数组里是对象，则复制对象的引用
         *@param ，原数组，原数组要复制的起始位置，目标数组，目标数组复制的起始位置，要复制的长度
         */

        return newArray;
    }
}
