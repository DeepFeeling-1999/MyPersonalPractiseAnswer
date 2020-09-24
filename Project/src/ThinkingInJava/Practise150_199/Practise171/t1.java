package ThinkingInJava.Practise150_199.Practise171;

abstract class temp1 {
    abstract void print();

    public temp1() {
        print();
    }
}

class temp2 extends temp1 {
    private int num = 333;

    void print() {
        System.out.println("temp2 = " + num);
    }
}

public class t1 {
    public static void main(String[] args) {
        temp2 t2 = new temp2();
        t2.print();
    }
}
