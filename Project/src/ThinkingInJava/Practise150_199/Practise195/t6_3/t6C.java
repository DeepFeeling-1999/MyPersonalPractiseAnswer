package ThinkingInJava.Practise150_199.Practise195.t6_3;

import ThinkingInJava.Practise150_199.Practise195.t6_2.*;
import ThinkingInJava.Practise150_199.Practise195.t6_1.*;

public class t6C extends t6 {
    public testInterface fun() {
        return this.new t6InnerClass();
    }

    public static void main(String[] args) {
        t6C temp = new t6C();
        temp.fun().testFun();
    }
}
