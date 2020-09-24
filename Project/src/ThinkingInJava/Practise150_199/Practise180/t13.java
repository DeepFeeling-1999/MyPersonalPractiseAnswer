package ThinkingInJava.Practise150_199.Practise180;

interface superInterface {
    void superFun();
}

interface temp2 extends superInterface {
    void temp2Fun();
}

interface temp3 extends superInterface {
    void temp3Fun();
}

interface subInterface extends temp2, temp3 {
    void subFun();
}

class testInterface implements subInterface {
    public void superFun() {
        System.out.println("testInterface superFun");
    }

    public void temp2Fun() {
        System.out.println("testInterface temp2Fun");
    }

    public void temp3Fun() {
        System.out.println("testInterface temp3Fun");
    }

    public void subFun() {
        System.out.println("testInterface subFun");
    }
}

public class t13 {
    public static void main(String[] args) {
        testInterface t1 = new testInterface();

        ((superInterface) t1).superFun();
        ((temp2) t1).temp2Fun();
        ((temp3) t1).temp3Fun();
        t1.subFun();

        t1.superFun();
        t1.temp2Fun();
        t1.temp3Fun();
        t1.subFun();
    }
}
