package ThinkingInJava.Practise354_400.Practise354;

class temp1 {
    @Override
    public String toString() {
        return "temp1 ";
    }
}

class temp11 extends temp1 {
    @Override
    public String toString() {
        return "temp11";
    }
}

public class t1<T> {
    private T a;

    public t1(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        t1<temp1> t = new t1<>(new temp1());

        System.out.println(t.getA());
        t.setA(new temp11());

        System.out.println(t.getA());
    }
}
