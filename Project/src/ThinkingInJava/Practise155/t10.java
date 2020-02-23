package ThinkingInJava.Practise155;

class temp1{
    public void fun1(){
        System.out.println("temp1 fun1");
        fun2();
    }
    public void fun2(){
        System.out.println("temp1 fun2");
    }
}
class temp2 extends temp1{
    @Override
    public void fun2(){
        System.out.println("temp2 fun2");
    }
}
public class t10 {
    public static void main(String[]args){
        temp1 t1=new temp2();

        t1.fun1();
    }
}
