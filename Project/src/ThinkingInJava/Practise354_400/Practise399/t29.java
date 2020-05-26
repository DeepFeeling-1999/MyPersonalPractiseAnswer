package ThinkingInJava.Practise354_400.Practise399;

import SomeInstance.Holder;

import java.util.ArrayList;
import java.util.List;

public class t29 {
    public static void fun1(Holder<List<?>> h) {
        
    }
    public static void fun2(List<Holder<?>> l){

    }

    public static void main(String[] args) {
        fun1(new Holder<List<?>>());
        System.out.println("***************");
        List<Holder<?>> list=new ArrayList<>();
        fun2(list);
    }
}
