package Test.Collection;

import java.util.*;


class temp1 implements Comparable {
    int number;

    public temp1(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(Object o) {
        return number - (((temp1) o).getNumber());
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "temp1 " + number;
    }
}

class temp2 {
    String st;

    public temp2(String st) {
        this.st = st;
    }

    public void fun() {
        System.out.println("fun " + st);
    }

    @Override
    public String toString() {
        return " temp2 " + st;
    }
}

public class MapTest {
    //以两个类为键值
    public static Map<temp1, temp2> m1 = new HashMap<>();

    public static void main(String[] args) {
        m1.put(new temp1(0), new temp2("ccc"));
        m1.put(new temp1(8), new temp2("bbb"));
        m1.put(new temp1(5), new temp2("fff"));
        m1.put(new temp1(9), new temp2("A"));

        Iterator<temp1> I = m1.keySet().iterator();

        while (I.hasNext()) {
            temp1 t1 = I.next();
            //获取下一个键

            System.out.println("key: temp1 = " + t1);
            System.out.println("value: temp2 = " + m1.get(t1));
            //以键获取值

            m1.get(t1).fun();
            System.out.println("***********");


            System.out.println("HashMap" + m1);
            System.out.println("**********");

            Set<temp1> set = new TreeSet<temp1>(m1.keySet());

            System.out.println("TreeSet" + set);
            System.out.println("**********");

            Map<temp1, temp2> m2 = new LinkedHashMap<>();
            for (temp1 t11 : set) {
                System.out.println("Adding " + t1);
                m2.put(t1, m1.get(t1));
            }
            System.out.println("\n**********");
            System.out.println(m2);

            System.out.println("\n**********");
            Map<temp1, temp2> tm = new TreeMap<>(m1);
            System.out.println(tm);

            System.out.println("**********");
            System.out.println("HashMap" + m1);

        }
    }
}