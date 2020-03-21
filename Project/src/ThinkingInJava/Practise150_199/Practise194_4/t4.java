package ThinkingInJava.Practise150_199.Practise194_4;

class OuterClass{
    public OuterClass(){
        System.out.println("OuterClass Constructor");
    }

    protected class InnerClass{
        public OuterClass getOutClass(){
            return OuterClass.this;
        }
        public InnerClass(){
            System.out.println("InnerClass Constructor");
        }
    }

    public InnerClass getInnerClass(){
        return new InnerClass();
    }
}
public class t4{
    public static void main(String[]args){
        OuterClass o1=new OuterClass();
        OuterClass.InnerClass i1=o1.getInnerClass();
        OuterClass.InnerClass i2=o1.new InnerClass();
        OuterClass.InnerClass i3=i1.getOutClass().getInnerClass();
    }
}