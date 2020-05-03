package ThinkingInJava.Practise354_400.Practise363;

import java.util.*;

class temp0{

}
class temp1 extends temp0{
    private int num;

    public temp1(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "temp1 " + num;
    }
}

class temp11 extends temp1 {
    private int num;

    public temp11(int num) {
        super(num);
        this.num = num;
    }

    @Override
    public String toString() {
        return "temp11 " + num;
    }
}

public class t11 {
    public static Map<temp1, List<?super temp1>> myMap = new HashMap<>();

    public static void main(String[] args) {
        temp1 t1=new temp1(1);
        myMap.put(t1, new ArrayList<>(Arrays.asList(new temp11(1),new temp11(11))));


        System.out.println(myMap.get(t1));
    }
}
