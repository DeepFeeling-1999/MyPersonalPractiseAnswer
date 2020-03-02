package Test.ATemp;

import java.util.Objects;

public class Test
{
    public static void main(String[] args) {
        int a=100;
        int b=100;
        System.out.println(Objects.hashCode(a)==Objects.hashCode(b));
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));

    }
}