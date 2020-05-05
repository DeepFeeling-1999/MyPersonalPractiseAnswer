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



    public static void main(String[]args){
        temp1 result=new temp1(666);
        temp1 tail =result;


        temp1 last=new temp1(999);
        tail=last;

        System.out.println(result);
        System.out.println(tail);
    }
}
