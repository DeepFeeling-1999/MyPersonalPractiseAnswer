package CoreJava.Chapter8_Generic.Pair1;

import CoreJava.Chapter8_Generic.Pair.Pair;

public class PairTest1 {
    public static void main(String[] args)
    {
        String[] words = { "Mary", "had", "a", "little", "lamb" };

        //使用了自动类型推断来代替
        //Pair<String> mm =ArrayAlg.<String>minmax(words);
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}

class ArrayAlg
{
    /**
     * 泛型方法，定义在普通类中
     */
    public static Pair<String> minmax(String[] a)
    {
        if (a == null || a.length == 0) {
            return null;
        }
        String min = a[0];
        String max = a[0];

        for (int i = 1; i < a.length; i++)
        {
            if (min.compareTo(a[i]) > 0)
                min = a[i];
            if (max.compareTo(a[i]) < 0)
                max = a[i];
        }
        return new Pair<>(min, max);
    }
}
