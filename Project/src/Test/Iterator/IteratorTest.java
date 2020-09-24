package Test.Iterator;


import java.util.Iterator;
import java.util.Random;

class temp {
    private int num;

    public temp(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "num " + num;
    }
}

public class IteratorTest implements Iterable<temp> {
    private temp[] temps;
    private Random r = new Random(33);

    public IteratorTest(int num) {
        temps = new temp[num];
        for (int i = 0; i < num; i++)
            temps[i] = new temp(r.nextInt(6));
    }

    @Override
    public Iterator<temp> iterator() {
        return new Iterator<temp>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < temps.length;
            }

            @Override
            public temp next() {
                return temps[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public Iterable<temp> reverse() {
        return new Iterable<temp>() {
            @Override
            public Iterator<temp> iterator() {
                return new Iterator<temp>() {
                    int current = temps.length - 1;

                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public temp next() {
                        return temps[current--];
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public static void main(String[] args) {
        IteratorTest ttttttt = new IteratorTest(5);

        for (temp t : ttttttt)
            System.out.println(t);
        System.out.println("**************");
        for (temp t : ttttttt.reverse())
            System.out.println(t);
    }
}
