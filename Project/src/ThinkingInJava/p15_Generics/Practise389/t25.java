package ThinkingInJava.p15_Generics.Practise389;

interface myInterfaceA {
    void funA();
}

interface myInterfaceB {
    void funB();
}

class temp implements myInterfaceA, myInterfaceB {
    @Override
    public void funA() {
        System.out.println("temp funA() ");
    }

    @Override
    public void funB() {
        System.out.println("temp funB() ");
    }
}

public class t25 {
    static <T extends myInterfaceB> void fun1(T t) {
        t.funB();
    }

    static <T extends myInterfaceA> void fun2(T t) {
        t.funA();
    }

    public static void main(String[] args) {
        temp t = new temp();

        fun1(t);
        fun2(t);
    }
}
