package ThinkingInJava.p10_innerclass.Practise195.t6_2;

import ThinkingInJava.p10_innerclass.Practise195.t6_1.*;

public class t6 {
    protected class t6InnerClass implements testInterface {
        public t6InnerClass() {}

        public void testFun() {
            System.out.println("t6InnerClass testFun");
        }
    }
}