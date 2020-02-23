package CoreJava.Chapter8_Generic.Pair3;

import CoreJava.Chapter8_Generic.Pair.Pair;

public class PairTest3
{
    public static void main(String[] args)
    {
        Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
        Manager cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 15);

        Pair<Manager> buddies = new Pair<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);
        Manager[] managers = { ceo, cfo };

        Pair<Employee> result = new Pair<>();
        minmaxBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName()
                + ", second: " + result.getSecond().getName());

        maxminBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName()
                + ", second: " + result.getSecond().getName());
    }

    /**
     * 通配符的子类限定,只可以读，不能写
     * @param p 是Employee类或其子类
     */
    public static void printBuddies(Pair<? extends Employee> p)
    {
        Employee first = p.getFirst();
        Employee second = p.getSecond();

        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    /**
     * 通配符的超类限定
     * 只可以写，不能读
     * @param a
     * @param result 是Manager的超类
     */
    public static void minmaxBonus(Manager[] a, Pair<? super Employee> result)
    {
        if (a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++)
        {
            if (min.getBonus() > a[i].getBonus())
                min = a[i];
            if (max.getBonus() < a[i].getBonus())
                max = a[i];
        }
        System.out.println(result.getFirst() + " aaa " + result.getSecond() + " aaaaaaa.");
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager[] a, Pair<? super Employee> result)
    {
        minmaxBonus(a, result);
        PairAlg.swapHelper(result); // OK--swapHelper captures wildcard type
    }
}

class PairAlg
{
    public static boolean hasNulls(Pair<?> p)
    {
        return p.getFirst() == null || p.getSecond() == null;
    }

    /**
     * 通配符捕获，通配符？不是类型变量，因此不能用？作为一种类型
     * @param p
     */
    public static void swap(Pair<?> p)
    {
        swapHelper(p);
    }

    /**
     * 辅助方法，可以用T捕获通配符，不知道是哪种类型，但是这是一个明确的类型
     * @param p
     * @param <T>
     */
    public static <T> void swapHelper(Pair<T> p)
    {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
