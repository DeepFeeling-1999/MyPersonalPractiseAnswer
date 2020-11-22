package ThinkingInJava.p11_Collection.Practise223;

import java.util.*;

class temp1 {
    int key = 0;

    public String next() {
        switch (key % 3) {
            default:
            case 0:
                key++;
                return "000";
            case 1:
                key++;
                return "111";
            case 2:
                key++;
                return "222";
        }
    }

    public void fillAr(String[] a) {
        for (int i = 0; i < a.length; i++)
            a[i] = next();
    }

    public Collection fill(Collection<String> c, int n) {
        for (int i = 0; i < n; i++)
            c.add(next());
        return c;
    }
}

public class t4 {
    public static void main(String[] args) {
        String[] ar = new String[3];
        temp1 t1 = new temp1();
        t1.fillAr(ar);

        for (String s : ar) System.out.print(s + ", ");
        System.out.println();
        System.out.println(t1.fill(new ArrayList<String>(), 2));
        System.out.println(t1.fill(new LinkedList<String>(), 5));
        System.out.println(t1.fill(new HashSet<String>(), 4));
        System.out.println(t1.fill(new LinkedHashSet<String>(), 6));
        System.out.println(t1.fill(new TreeSet<String>(), 3));
    }
}
