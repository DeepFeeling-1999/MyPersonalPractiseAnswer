package ThinkingInJava.Practise301_350.Practise337;

import java.lang.reflect.InvocationTargetException;

class temp1 {
    int num;

    public temp1() {
        System.out.println("temp1()");
    }

    public temp1(int i) {
        num = i;
        System.out.println("temp1(int i) " + i);
    }

    public void fun() {
        System.out.println("temp1 fun() " + num);
    }
}

class temp11 extends temp1 {
    public temp11() {
        super(666);
        System.out.println("temp11()");
    }
}

public class t19 {
    public static void main(String[] args) {
        try {
            String c = "ThinkingInJava.Practise301_350.Practise337.temp1";
            Class<?> cTemp = Class.forName(c);

            // temp1.class.getDeclaredConstructor(int.class).newInstance(1);
            temp1 t = (temp1) cTemp.getDeclaredConstructor(int.class).newInstance(666);

            t.fun();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            System.exit(666);
        }
    }
}
