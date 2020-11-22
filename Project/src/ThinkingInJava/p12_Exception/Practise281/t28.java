package ThinkingInJava.p12_Exception.Practise281;

class temp28_1 extends RuntimeException {
    private String st;

    public temp28_1(String st) {
        this.st = st;
    }

    @Override
    public String getMessage() {
        return " getMessage " + st + "  *****  " + super.getMessage();
    }
}

public class t28 {
    public static void fun28() {
        throw new temp28_1("t28 fun28() ");
    }

    public static void main(String[] args) {
        //try{

        fun28();//继承自RuntimeException，所以不用异常说明和try-catch块

       /*}catch (Exception e ){
           System.out.println(" catch run");
       }*/
    }
}
