package ThinkingInJava.Practise253_300.Practise263;

public class t11 {
    public static void g()throws temp1{
        throw new temp1("temp1 from main f()");
    }
    public static void f() throws temp1,temp2 {
            try{
                g();
            }
            catch(temp1 e){
                System.out.println("main catch(temp1 e)");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
    }

    public static void main(String[]args) throws temp2, temp1 {
        f();
    }
}
