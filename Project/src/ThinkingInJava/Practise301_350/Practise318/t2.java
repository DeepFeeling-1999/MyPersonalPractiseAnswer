package ThinkingInJava.Practise301_350.Practise318;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

interface interface1 {}

interface interface2 {}

class temp1 {
    //temp1(){}
    temp1(int t) {}
}

class temp11 extends temp1 implements interface1, interface2 {
    public temp11() {
        super(1);
    }
}

public class t2 {
    static void printInfo(Class cc) {
        System.out.println("Class name \n" + cc.getName() + "\nis interface \n" + Arrays.toString(cc.getInterfaces()) + "\nCanonical name \n" + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("ThinkingInJava.Practise301_350.Practise318.temp11");

        } catch (ClassNotFoundException e) {
            System.err.println("Can't find toy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces())
            printInfo(face);


        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            System.err.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        printInfo(obj.getClass());
    }
}
