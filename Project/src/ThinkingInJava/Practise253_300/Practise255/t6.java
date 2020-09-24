package ThinkingInJava.Practise253_300.Practise255;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class temp extends Exception {
    private static Logger l = Logger.getLogger("temp Logger ");

    public temp() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        l.severe(trace.toString());
    }
}

public class t6 {
    public static void main(String[] args) {
        try {
            throw new temp();
        } catch (Exception t) {
            System.out.println("catch ");
        } finally {
            System.out.println("finally ");
        }

    }
}
