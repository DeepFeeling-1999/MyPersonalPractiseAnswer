package SomeInstance;

public class temp11 extends temp1{
    String st;
    public temp11(){
        System.out.println("public temp11()");
    }
    public temp11(int num){
        super(num);
        st="null";
        System.out.println("public temp11(int num)");
    }
    public temp11(String st){
        this.st=st;
        System.out.println("public temp1(String st)");
    }
    public temp11(String st,int num){
        super(num);
        this.st=st;
        System.out.println("public temp11(String st,int num)");
    }

    @Override
    public String toString() {
        return "temp11 extends temp11 + "+st;
    }
}
