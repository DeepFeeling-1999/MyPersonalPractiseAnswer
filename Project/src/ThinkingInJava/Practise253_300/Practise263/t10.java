package ThinkingInJava.Practise253_300.Practise263;

class temp1 extends Exception{
    private String st;

    public temp1(String st) {
        this.st = st;
    }

    @Override
    public String getMessage(){
        return "getMessage + st "+st;
    }
    protected void fun(){
        System.out.println("temp1 fun()");
    }
}

class temp2 extends Exception{
    private String st;

    public temp2(String st) {
        this.st = st;
    }

    @Override
    public String getMessage(){
        return "getMessage + st "+st;
    }
    protected void fun(){
        System.out.println("temp1 fun()");
    }
}
public class t10
{
    public static void g()throws temp1{
        throw new temp1("temp1 from main f()");
    }
    public static void f() throws temp1,temp2 {
           try{
               try{
                   g();
               }
               catch(temp1 e){
                   System.out.println("main catch(temp1 e)");
                   e.printStackTrace();
                   System.out.println("**************");
                   throw (Exception)e.fillInStackTrace();
                   //throw new temp2("temp2: from catch(temp1 e) ");
               }

           } catch (Exception e){
               System.out.println("main catch(temp2 e)");
               e.printStackTrace();
           }
    }

    public static void main(String[]args) throws temp2, temp1 {
        f();
    }
}
