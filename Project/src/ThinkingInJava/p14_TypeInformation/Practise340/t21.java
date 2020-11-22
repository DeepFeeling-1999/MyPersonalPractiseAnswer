package ThinkingInJava.p14_TypeInformation.Practise340;

interface MyInterface {
    void doSomething();

    void somethingElse();
}

class temp implements MyInterface {
    public void doSomething() {
        System.out.println("temp doSomething");
    }

    public void somethingElse() {
        System.out.println("temp somethingElse");
    }
}

class MyProxy implements MyInterface {
    public static int doAmount = 0;
    public static int doElseAmount = 0;
    private MyInterface proxied;

    public MyProxy(MyInterface proxied) {
        this.proxied = proxied;
    }

    public void doSomething() {
        System.out.println("MyProxy doSomething");
        doAmount++;
        proxied.doSomething();
    }

    public void somethingElse() {
        System.out.println("MyProxy somethingElse");
        doElseAmount++;
        proxied.somethingElse();
    }
}

public class t21 {
    public static void fun(MyInterface myInterface) {
        myInterface.doSomething();
        myInterface.somethingElse();
    }

    public static void main(String[] args) {
        fun(new temp());
        System.out.println("*********************");
        fun(new MyProxy(new temp()));
    }

}
