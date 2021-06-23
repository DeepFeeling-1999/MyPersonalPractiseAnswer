package Thread.SaleTicket;

/**
 * 表明是函数式接口
 */
@FunctionalInterface
interface test{

    int add(int x,int y);
    //void say2(int num);

    /**
     *默认实现，可以有多个
     */
    default int mul0(int x,int y){
        return x*y;
    }
    default int mul1(int x,int y){
        return y;
    }

    static int mul2(int x){
        return x;
    }
    static int mul3(int x){
        return x;
    }
}

/**
 * 匿名内部类，解决代码冗余的现象,只能有一个方法
 */
public class LanbdaSale {
    public static void main(String []args){


        test t=(int x,int y)->{
            System.out.println("x+y = "+(x+y));
            return x+y;
        };
        t.add(6,7);
       System.out.println(t.mul0(6, 7));
        System.out.println(t.mul1(6,7));
    }
}
