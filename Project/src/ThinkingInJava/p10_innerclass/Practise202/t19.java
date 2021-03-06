package ThinkingInJava.p10_innerclass.Practise202;

public class t19 {
    protected static class temp1 {
        String st1 = "st1";
        static int t1 = 1;

        public temp1() {
            System.out.println("static class temp1 constructor");
        }

        protected static class temp11 {
            String st11 = "st11";
            static int t11 = 11;

            public temp11() {
                System.out.println("static class temp11 constructor");
            }
        }
    }

    protected class temp2 {
        String st2 = "st2";
        int t2 = 2;

        public temp2() {
            System.out.println("static class temp2 constructor");
        }

        protected class temp22 {
            String st22 = "st22";
            int t22 = 22;

            public temp22() {
                System.out.println("static class temp22 constructor");
            }
        }
    }

    public static void main(String[] args) {
        temp1 t1 = new temp1();
        temp1.temp11 t11 = new temp1.temp11();

        t19 t = new t19();

        //普通内部类须由外到内
        t19.temp2 t2 = t.new temp2();
        t19.temp2.temp22 t22 = t2.new temp22();
        //.new不适用于静态内部类
    }
}
