package ThinkingInJava.Practise253_300.Practise253;

class temp extends Exception{
    private String st;
    public temp(String st){
        this.st=st;
    }

    public void fun() throws temp{
        System.out.println("st "+st);
        throw new temp(st);
    }
}
public class t4
{
    public static void fun()throws temp{
        System.out.println("main fun ");
        throw new temp("From fun() ");
    }
    public static void main(String[]args) throws temp
    {
        temp t1=new temp("t1 ");

        temp t11=null;
        //t11.fun();
        try{
            t11.fun();
            fun();
            //t1.fun();
        }catch(temp t){
            System.out.println("catch temp in main ");
            t.printStackTrace();
        }catch (NullPointerException e){
            System.out.println("NullPointerException ");
            e.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException ");
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }

    }
}
