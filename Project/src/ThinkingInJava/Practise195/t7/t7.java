package ThinkingInJava.Practise195.t7;

class test{
    private String st1;

    public test(String st1){
        this.st1=st1;
    }
    private String getSt1(){
        return st1;
    }

    protected class InnerClass {
        private String st2;
        public InnerClass(String st2){
             this.st2=st2;
        }
        public void setSt1(String st) {
            st1 = st;
            System.out.println(getSt1());
        }
    }

    public void testInnerClass(){
        InnerClass tempInnerClass=new InnerClass("test Inner Class in Outer class function");
        tempInnerClass.setSt1("666666");
    }
}
public class t7{
    public static void main(String[]args){
        new test("1111").testInnerClass();
    }
}
