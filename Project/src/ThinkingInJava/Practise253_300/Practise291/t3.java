package ThinkingInJava.Practise253_300.Practise291;

import java.io.PrintStream;
import java.util.Formatter;

public class t3 {
    public static void main(String[] args) {
        PrintStream p = System.err;
        Formatter f = new Formatter(p);

        float fl = 333;
        int num = 0;
        f.format("666 %f\n", fl);

        f.format("%b  \n", num);
    }
}
