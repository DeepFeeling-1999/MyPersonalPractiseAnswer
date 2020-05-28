package ThinkingInJava.Practise201_250.Practise212;

class Temp1 {
    class Temp11 {
        public Temp11(String st) {
            System.out.println("Temp11 " + st);
        }
    }
}

class Temp2 {
    class Temp22 extends Temp1.Temp11 {
        public Temp22(Temp1 T1) {
            T1.super("aaa");
        }
    }
}

public class t26 {
    public static void main(String[] args) {
        Temp1 t1 = new Temp1();
        Temp2 t2 = new Temp2();
        Temp2.Temp22 t22 = t2.new Temp22(t1);
    }
}
