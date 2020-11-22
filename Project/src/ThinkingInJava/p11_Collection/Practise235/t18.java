package ThinkingInJava.p11_Collection.Practise235;

import java.util.*;

public class t18 {
    public static void main(String[] args) {
        Map<temp1, temp2> m1 = new HashMap<>();
        m1.put(new temp1(0), new temp2("A"));
        m1.put(new temp1(6), new temp2("fff"));
        m1.put(new temp1(4), new temp2("zzz"));
        m1.put(new temp1(9), new temp2("hhh"));

        System.out.println("HashMap" + m1);
        System.out.println("**********");

        Set<temp1> set = new TreeSet<>(m1.keySet());

        System.out.println("TreeSet" + set);
        System.out.println("**********");

        Map<temp1, temp2> m2 = new LinkedHashMap<>();
        for (temp1 t1 : set) {
            System.out.println("Adding " + t1);
            m2.put(t1, m1.get(t1));
        }
        System.out.println("\n**********");
        System.out.println(m2);

        System.out.println("\n**********");
        Map<temp1, temp2> tm = new TreeMap<>(m1);
        System.out.println(tm);

        System.out.println("**********");
        System.out.println("TreeMap" + tm);

    }
}
