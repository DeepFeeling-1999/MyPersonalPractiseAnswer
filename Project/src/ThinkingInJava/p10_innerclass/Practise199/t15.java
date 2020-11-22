package ThinkingInJava.p10_innerclass.Practise199;

class temp1 {
    String st;

    public temp1(String st) {
        this.st = st;
    }

    public String getSt() {
        return st;
    }
}

class temp2 {
    public temp1 temp2Fun() {
        return new temp1("temp2 fun") {};
    }
}

public class t15 {
    public static void main(String[] args) {
        System.out.println(new temp2().temp2Fun().getSt());
    }
}
