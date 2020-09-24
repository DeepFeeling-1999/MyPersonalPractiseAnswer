package ThinkingInJava.Practise201_250.Practise228;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class t12b {
    public static void main(String[] args) {
        List<Integer> li11 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> li22 = new ArrayList<>(li11);
        ListIterator<Integer> i11 = li11.listIterator(6);
        ListIterator<Integer> i22 = li22.listIterator();

        while (i22.hasNext()) {
            i22.next();
            i22.set(i11.previous());
        }

        System.out.println(li11);
        System.out.println(li22);

    }
}