package Test.ATemp;

import ThinkingInJava.Practise150_199.Practise159.t11;

class temp1{
    protected class temp11{
        public temp11(){System.out.println("temp11 constructor");};
        public void fun(){
            System.out.println("temp1 fun()");
        }
    }

    temp11 t11=new temp11();
    public temp1(){
        System.out.println("temp1 constructor");
    }

    public void gFun(){
        t11.fun();
    }

}


public class Test extends temp1
{
    class temp2 {
        public class temp22 extends temp1.temp11{

        }

    }
    public static void main(String[] args)
    {
    }

}