package ThinkingInJava.Practise150_199.Practise196;

interface testInterface{
    void fun();
}

public class temp
{
    public static testInterface mainFun(){
        class InnerClass implements testInterface{
            public void fun(){
                System.out.println("mainFun InnerClass fun interface");
            }
        }
        return new InnerClass();
    }
    public static void main(String[]args){
        testInterface t1=mainFun();
        t1.fun();
    }
}
