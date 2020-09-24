package ThinkingInJava.Practise201_250.Practise229;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class t14 {
    public static void main(String[] args) {
        LinkedList<Integer> L14 = new LinkedList<>();

        Integer[] ar = {0, 1, 2, 3, 4, 5, 6};
        Iterator<Integer> It14 = L14.iterator();

        for (Integer i : ar) {
            ListIterator<Integer> LI = L14.listIterator((L14.size()) / 2);
            LI.add(i);
            System.out.println(L14);
        }

    }
}
