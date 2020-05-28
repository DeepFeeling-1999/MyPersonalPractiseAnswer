package ThinkingInJava.Practise354_400.Practise364;

import java.util.*;


class temp1 {
    int num;

    public temp1(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "temp1 + " + num;
    }
}

class temp1Genetator implements myGenerator<temp1> {


    @Override
    public String toString() {
        return "temp11 + ";
    }

    @Override
    public temp1 next(int num) {
        return new temp1(num);
    }
}

public class t13 {
    public static <T> Set<T> fill(Set<T> myList, myGenerator<T> m, int n) {
        System.out.println(" public static <T> Set<T> fill");
        for (int i = 0; i < n; i++)
            myList.add(m.next(i));
        return myList;
    }

    public static <T> LinkedList<T> fill(LinkedList<T> myLinkedList, myGenerator<T> m, int n) {
        System.out.println("public static <T> LinkedList<T> fill");
        for (int i = 0; i < n; i++) {
            myLinkedList.add(m.next(i));
        }
        return myLinkedList;
    }

    public static void main(String[] args) {
        Collection<temp1> co = fill(new LinkedList<temp1>(), new temp1Genetator(), 3);
        for (temp1 t1 : co) {
            System.out.println(t1);
        }

        Set<temp1> S1 = fill(new HashSet<>(), new temp1Genetator(), 3);
        for (temp1 t1 : S1) {
            System.out.println(t1);
        }
    }

}
