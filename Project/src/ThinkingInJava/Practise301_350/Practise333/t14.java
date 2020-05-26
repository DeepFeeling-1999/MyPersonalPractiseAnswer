package ThinkingInJava.Practise301_350.Practise333;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Factory<T> {
    T create();
}

class temp2 {
    public static class ttt implements Factory<temp2>{
        public temp2 create(){
            return new temp2();
        }
    }
    @Override
    public String toString() {
        return " temp2";
    }
}

class temp22 extends temp2 {
    public static class ttt implements Factory<temp22>{
        @Override
        public temp22 create(){
            return new temp22();
        }
    }
    @Override
    public String toString() {
        return " temp22";
    }
}

class temp222 extends temp2 {
    public static class ttt implements Factory<temp222>{
        public temp222 create(){
            return new temp222();
        }
    }
    @Override
    public String toString() {
        return " temp222";
    }
}

public class t14 {
    static List<Class<? extends temp2>> partClass=
            new ArrayList<>(Arrays.asList(temp2.class,temp22.class,temp222.class));
    private static List<Factory<?extends temp2>> partFactory=
            new ArrayList<Factory<?extends temp2>>(Arrays.asList(new temp2.ttt(),new temp22.ttt(),new temp222.ttt()));

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }


    public static void main(String[]args)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
       for(Class<?>c:partClass){
           System.out.println(c.getDeclaredConstructor().newInstance());
       }
       for(Factory t: partFactory) {
           System.out.println(t.create());
       }
    }
}
