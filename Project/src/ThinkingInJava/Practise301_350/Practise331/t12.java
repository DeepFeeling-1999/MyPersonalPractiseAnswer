package ThinkingInJava.Practise301_350.Practise331;

import java.util.HashMap;


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

class temp222 extends temp22 {
    @Override
    public String toString() {
        return " temp222";
    }
}

class tempCounter extends HashMap<Class<?>, Integer> {
    private final Class<?> baseType;

    public tempCounter(Class<?> c) {
        baseType = c;
    }

    public void count(Object obj) {
        Class<?> type = obj.getClass();

        //看参数是不是它的子类
        if (!baseType.isAssignableFrom(type)) {
            throw new RuntimeException(obj + " incorrect type");
        }
        countClass(type);
    }

    public void countClass(Class<?> c) {
        Integer quantity = get(c);
        put(c, quantity == null ? 1 : quantity + 1);

        Class<?> superClass = c.getSuperclass();
        if (superClass != null && baseType.isAssignableFrom(superClass)) {
            countClass(superClass);
        }
    }
}

public class t12 {
    public static void main(String[] args) {
        tempCounter ttt = new tempCounter(temp2.class);

        temp2[] ar = {new temp2(), new temp22(), new temp222()};
        for (temp2 t : ar) {
            ttt.count(t);
        }

        System.out.println(ttt);
    }
}
