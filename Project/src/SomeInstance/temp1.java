package SomeInstance;

public class temp1 {
    private int num;

    public temp1(){
        System.out.println("public temp1()");
    }
    public temp1(int num){
        this.num=num;
        System.out.println("public temp1(int num)");
    }

    @Override
    public String toString() {
        return "temp1 + "+num;
    }
}
