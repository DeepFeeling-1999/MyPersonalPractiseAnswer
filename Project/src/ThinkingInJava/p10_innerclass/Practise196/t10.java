package ThinkingInJava.p10_innerclass.Practise196;

class temp10 {
    class innerT10Class implements testInterface {
        public void fun() {
            System.out.println("t10 InnerClass fun interface");
        }

        public void fun2() {
            System.out.println("fun2");
        }
    }

    public testInterface fun333() {
        return new innerT10Class();
    }
}

public class t10 {
    public static void main(String[] args) {
        temp10 t = new temp10();
        t.fun333().fun();
        ((temp10.innerT10Class) t.fun333()).fun2();
    }
}