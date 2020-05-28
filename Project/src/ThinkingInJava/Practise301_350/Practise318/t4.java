package ThinkingInJava.Practise301_350.Practise318;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class temp2 {
    @Override
    public String toString() {
        return " temp2";
    }
}

class temp22 extends temp2 {
    @Override
    public String toString() {
        return " temp22";
    }
}

class temp222 extends temp2 {
    @Override
    public String toString() {
        return " temp222";
    }
}

public class t4 {
    public static void main(String[] args) {
        List<temp2> tL = new ArrayList<>(Arrays.asList(new temp2(), new temp22(), new temp222()));

        for (temp2 t : tL) {
            System.out.println(t);
        }

        temp2 t2 = new temp2();
        temp22 t22 = new temp22();

        System.out.println("**************************");
        if (t22 instanceof temp2) {
            System.out.println((temp2) t22);
        }

        if (t2 instanceof temp22) {
            System.out.println((temp22) t2);
        }
    }
}
