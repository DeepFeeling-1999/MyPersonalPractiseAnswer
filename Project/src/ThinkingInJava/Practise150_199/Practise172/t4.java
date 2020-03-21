package ThinkingInJava.Practise150_199.Practise172;

class temp1{

}
class temp11 extends temp1{
    public void fun(){
        System.out.println("temp11 fun()");
    }
}

abstract class temp2{
    abstract void fun();
}
class temp22 extends temp2{
    void fun(){
        System.out.println("temp11 fun()");
    }
}


public class t4 {
    static void fun1(temp1 t1){
        ((temp11)t1).fun();
    }
    static void fun2(temp2 t2){
        t2.fun();
    }
    public static void main(String []args){
        temp11 t2=new temp11();
        fun1(t2);
    }
}
