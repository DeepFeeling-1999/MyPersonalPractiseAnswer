package ThinkingInJava.p15_Generics.Practise370;

import ThinkingInJava.p15_Generics.Practise364.myGenerator;
import ThinkingInJava.p15_Generics.Practise364.t13;

import java.util.*;


class temp1 {
    int num = 0;

    public temp1(int num) {
        this.num = num;
    }

    public static myGenerator<temp1> generator() {
        return new myGenerator<temp1>() {
            @Override
            public temp1 next(int num) {
                return new temp1(666);
            }
        };
    }
}

class temp2 {
    int num2 = 0;

    public temp2(int num2) {
        this.num2 = num2;
    }

    public static myGenerator<temp2> generator = new myGenerator<temp2>() {
        @Override
        public temp2 next(int num) {
            return new temp2(222);
        }
    };
}

public class t18 {
    public static void main(String[] args) {
        Set<temp1> s = t13.fill(new HashSet<temp1>(), temp1.generator(), 3);
        for (temp1 t1 : s) {
            System.out.println(t1);
        }

        List<temp2> l2 = t13.fill(new LinkedList<temp2>(), temp2.generator, 3);
        for (temp2 t2 : l2) {
            System.out.println(t2);
        }
    }
}
