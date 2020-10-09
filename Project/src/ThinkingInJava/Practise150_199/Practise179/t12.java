package ThinkingInJava.Practise150_199.Practise179;

interface i1 {
    void fun1();
}

interface i2 {
    void fun2();
}

interface i3 {
    void fun3();
}

interface CanClimb {
    void CanClimb();
}

class superClass {
    public void fun1() {
        System.out.println("superClass fun1");
    }
}

class test extends superClass implements i1, i2, i3, CanClimb {
    public void fun2() {
        System.out.println("t3 fun2");
    }

    public void fun3() {
        System.out.println("t3 fun3");
    }

    public void CanClimb() {
        System.out.println("CanClimb fun");
    }
}

public class t12 {
    public static void main(String args[]) {
        test t = new test();
        t.CanClimb();
        t.fun1();
        t.fun2();
        t.fun3();
    }
}
