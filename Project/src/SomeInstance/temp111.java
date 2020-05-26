package SomeInstance;


public class temp111 extends temp1{
    String st;
    public temp111(){
        System.out.println("public temp111()");
    }
    public temp111(int num){
        super(num);
        st="nul1l";
        System.out.println("public temp111(int num)");
    }
    public temp111(String st){
        this.st=st;
        System.out.println("public temp111(String st)");
    }
    public temp111(String st,int num){
        super(num);
        this.st=st;
        System.out.println("public temp111(String st,int num)");
    }

    @Override
    public String toString() {
        return "temp111 extends temp111 + "+st;
    }
}
