package ThinkingInJava.Practise354_400.Practise395;

public class t28 {
    class myGeneric1<T> {
        T t;

        public void fun1(T t) {
            this.t = t;
        }
    }

    class myGeneric2<T> {
        T t;

        public T fun2() {
            return t;
        }
    }

    public <T> void fun1(myGeneric1<? super T> t,T t1) {
        t.fun1(t1);
    }

    public <T> void fun2(myGeneric2<? extends T> t) {
        t.fun2();
    }

    public static void main(String[] args) {
        t28 t = new t28();

    }
}
