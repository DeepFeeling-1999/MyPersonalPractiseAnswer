package ThinkingInJava.Practise354_400.Practise367;

class TwoTuple<A,B>{
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;

        this.second = second;
    }
}
class Tuple{
    public static <A,B> TwoTuple<A,B> tuple(A a,B b){
        return new TwoTuple(a,b);
    }
}
public class t15 {
    static  TwoTuple<String,Integer> f(){
        return Tuple.tuple("aaa",666);
    }
    static  TwoTuple  f2(){
        return Tuple.tuple("aaa",666);
    }

    public static void main(String[]args){
        TwoTuple<String,Integer> t=f();
        TwoTuple<String,Integer> t2=f2();
        System.out.println(f2());
    }
}
