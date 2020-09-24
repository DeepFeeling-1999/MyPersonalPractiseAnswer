package ThinkingInJava.Practise354_400.Practise362;

public class t10 {
    public static <A, B, C> void fun(A a, B b, Integer c) {
        System.out.println("A " + a.getClass().toString());
        System.out.println("b " + b.getClass().toString());
        System.out.println("c " + c.getClass().toString());
    }

    public static void main(String[] args) {
        fun("A", 3.33, 3);
    }
}
