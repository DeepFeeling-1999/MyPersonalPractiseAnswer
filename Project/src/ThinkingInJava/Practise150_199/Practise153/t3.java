package ThinkingInJava.Practise150_199.Practise153;

class temp1 {
    public void fun() {
        System.out.println("temp1");
    }
}

class temp2 extends temp1 {

}

public class t3 {
    public static void main(String[] args) {
        new temp2().fun();
    }
}
