package ThinkingInJava.Practise354_400.Practise375;

interface myInterface {
    void fun1();

    void fun2();
}

class temp1 implements myInterface {
    @Override
    public void fun1() {
        System.out.println("temp1 fun1()");
    }

    @Override
    public void fun2() {
        System.out.println("temp1 fun2()");
    }

    public void fun3() {
        System.out.println("temp1 fun2()");
    }
}
class temp11 extends temp1{
    public void temp11Fun(){
        System.out.println("temp11Fun()");
    }
}
class temp2 {
    public static <T extends temp1> void fun(T t) {
        t.fun1();
        t.fun2();
    }
}

public class t20 {
    public static void main(String[] args) {
        temp1 t1=new temp1();
        temp11 t11=new temp11();

        temp2.fun(t1);
        temp2.fun(t11);
    }
}
