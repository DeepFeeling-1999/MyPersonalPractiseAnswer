package ThinkingInJava.Practise150_199.Practise174.practise5.t5;

import ThinkingInJava.Practise150_199.Practise174.practise5.interfaceTest.*;

class T55 implements t1 {
    public void fun1() {
        System.out.println("fun1");
    }

    public void fun2() {
        System.out.println("fun2");
    }

    public void fun3() {
        System.out.println("fun3");
    }
}

public class T555 {
    public static void main(String[] args) {
        T55 t = new T55();

        t.fun1();
        t.fun2();
        t.fun3();
    }
}
