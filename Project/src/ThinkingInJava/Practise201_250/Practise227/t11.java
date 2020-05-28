package ThinkingInJava.Practise201_250.Practise227;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

class temp11 {
    String st;

    public temp11(String st) {
        this.st = st;
    }

    @Override
    public String toString() {
        return st;
    }
}

public class t11 {
    public static void main(String[] args) {
        Collection<temp11> c1 = new HashSet<temp11>(Arrays.asList(new temp11("111"), new temp11("222"), new temp11("333")));
        Iterator<temp11> I11 = c1.iterator();
        while (I11.hasNext()) System.out.println(I11.next());

    }
}
