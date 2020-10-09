package ThinkingInJava.Practise150_199.Practise194_5;

class OuterClass {
    public OuterClass() {
        System.out.println("OuterClass Constructor");
    }

    protected class InnerClass {
        public InnerClass() {
            System.out.println("InnerClass Constructor");
        }

        public String test() {
            return "InnerClass t3";
        }
    }

    public InnerClass getInnerClass() {
        return new InnerClass();
    }

    public String test() {
        return "OuterClass t3";
    }
}

class temp {
    private OuterClass o1 = new OuterClass();
    private OuterClass.InnerClass i1 = o1.new InnerClass();

    public temp() {
        System.out.println("InnerClass t3 + " + i1.test());
        System.out.println("OuterClass t3 + " + o1.test());
    }

    ;
}

public class t5 {
    public static void main(String[] args) {
        temp t1 = new temp();
    }
}