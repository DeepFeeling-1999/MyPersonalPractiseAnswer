package ThinkingInJava.Practise253_300.Practise269;

import java.util.concurrent.ExecutionException;

class temp1 extends Exception {
    @Override
    public String getMessage() {
        return "temp1 getMessage" + super.getMessage();
    }

    public String toString() {
        return "temp1 toString";
    }
}

class temp2 extends Exception {
    @Override
    public String getMessage() {
        return "temp2 getMessage" + super.getMessage();
    }

    public String toString() {
        return "temp2 toString";
    }
}

class temp3 extends Exception {
    @Override
    public String getMessage() {
        return "temp3 getMessage" + super.getMessage();
    }

    public String toString() {
        return "temp3 toString";
    }
}

public class t18 {
    public void f1() throws temp1 {
        throw new temp1();
    }

    public void f2() throws temp2 {
        throw new temp2();
    }

    public void f3() throws temp3 {
        throw new temp3();
    }

    public static void main(String[] args) throws temp1, temp3 {
        try {
            t18 t = new t18();
            try {
                try {
                    t.f1();
                } finally {
                    t.f3();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
