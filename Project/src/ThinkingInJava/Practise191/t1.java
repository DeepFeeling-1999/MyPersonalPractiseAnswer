package ThinkingInJava.Practise191;

class OuterClass{
    public OuterClass(){
        System.out.println("OuterClass Constructor");
    }

    protected class InnerClass{
        public InnerClass(){
            System.out.println("InnerClass Constructor");
        }
    }

    public InnerClass getInnerClass(){
        return new InnerClass();
    }
}
public class t1{
    public static void main(String[]args){
        OuterClass o1=new OuterClass();
        OuterClass.InnerClass i1=o1.getInnerClass();
    }
}