package ThinkingInJava.Practise150_199.Practise192_3;

class OuterClass{
    private String st;

    public OuterClass(String st){
        this.st=st;
        System.out.println("OuterClass Constructor");
    }

    protected class InnerClass{
        public InnerClass(){
            System.out.println("InnerClass Constructor");
        }
        public String getOutclassString(){
            return st;
        }
    }

    public InnerClass getInnerClass(){
        return new InnerClass();
    }
}

public class t3{
    public static void main(String[]args){
        OuterClass o1=new OuterClass("Six");
        OuterClass.InnerClass i1=o1.new InnerClass();
        System.out.println(i1.getOutclassString());
    }
}