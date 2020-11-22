package ThinkingInJava.p8_Extends.Practise156;

class temp1 {
    private void fun() {
        System.out.println("temp1");
    }
}

class temp2 extends temp1 {
    public void fun() {
        System.out.println("temp2");
    }
}

public class test {
    public static void main(String[] args) {
        // new temp1().fun();
    }
}