package ThinkingInJava.p12_Exception.Practise256;

class temp1 extends Exception {
    private String st;

    public temp1(String st) {
        this.st = st;
    }

    @Override
    public String getMessage() {
        return "getMessage + st " + st;
    }

    protected void fun() {
        System.out.println("temp1 fun()");
    }
}

public class t8 {
    public static void fun8() throws temp1 {
        System.out.println("t8 fun8() ");
        throw new temp1("from t8 fun8");
    }

    public static void main(String[] args) {
        try {
            fun8();
        } catch (temp1 t) {
            System.err.println("catch temp1 exception");
            System.err.println(t);
            t.printStackTrace();
        }
    }
}
