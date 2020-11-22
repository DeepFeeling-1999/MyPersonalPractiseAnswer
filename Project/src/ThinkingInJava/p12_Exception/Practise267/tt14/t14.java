package ThinkingInJava.p12_Exception.Practise267.tt14;


class Switch {
    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        System.out.println(this);
    }

    public void off() {
        state = false;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return state ? "true" : "false";
    }

}

class temp1 extends Exception {}

class temp2 extends Exception {}

public class t14 {
    private static Switch sw = new Switch();
    static Integer[] x = new Integer[1];

    public static void f(int i) throws temp1, temp2 {

    }

    public static void main(String[] args) {
        try {
            sw.on();
            f(x[0]); //空指针异常
            sw.off();
        } catch (temp1 e) {
            System.out.println("temp1");
            sw.off();
        } catch (temp2 e) {
            System.out.println("temp2");
            sw.off();
        }
    }
}
