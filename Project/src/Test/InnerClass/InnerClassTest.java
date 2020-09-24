package Test.InnerClass;

public class InnerClassTest {
    //静态内部类，也叫嵌套类，创建嵌套类并不需要外围类对象实例
    //没有this引用，相当于静态方法
    protected static class temp1 {
        //可包含静态域
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

    //普通内部类，要创建须先创建外围类实例
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
        //创建静态内部类可直接创建
        temp1 t1 = new temp1();
        temp1.temp11 t11 = new temp1.temp11();

        InnerClassTest t = new InnerClassTest();

        //普通内部类须由外到内
        InnerClassTest.temp2 t2 = t.new temp2();
        InnerClassTest.temp2.temp22 t22 = t2.new temp22();
        //.new不适用于静态内部类
    }
}
