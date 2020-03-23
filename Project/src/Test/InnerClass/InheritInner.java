package Test.InnerClass;

//内部类的继承
class Temp1{
    public Temp1(){
        System.out.println("Temp1 ");
    }
    protected class Temp11{
        public Temp11(String st){
            System.out.println("Temp11 " + st);
        }
    }
}

class Temp2{
    //若Temp2继承自Temp1则有必要的外围类引用

    public Temp2(){
        System.out.println("Temp2 ");
    }
    public class Temp22 extends Temp1.Temp11{
        //传递必要的外围类引用
        public Temp22(Temp1 t1){
            t1.super("aaa");
        }
    }
}
public class InheritInner
{
    public static void main(String[]args){
        Temp1 t1=new Temp1();
        Temp2 t2=new Temp2();
        Temp2.Temp22 t22=t2.new Temp22(t1);
    }
}
