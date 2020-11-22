package ThinkingInJava.p15_Generics.Practise361;

import java.util.Iterator;

interface Generator<T> {
    T myNext();
}

public class t7 implements Generator<Integer>, Iterable<Integer> {
    private int count = 0;
    private int amount;

    @Override
    public Integer myNext() {
        return fib(count++);
    }

    private int fib(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return fib(num - 2) + fib(num - 1);
        }
    }

    public t7() {
    }

    public t7(int amount) {
        this.amount = amount;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return amount > 0;
            }

            @Override
            public Integer next() {
                amount--;
                return myNext();
            }
        };
    }

    public static void main(String[] args) {
        t7 t = new t7(5);

        for (int i = 0; i < 5; i++) {
            System.out.println(t.myNext() + " ");
        }

        System.out.println("******************");
        for (Integer i : t) {
            System.out.println(i);
        }
    }
}
