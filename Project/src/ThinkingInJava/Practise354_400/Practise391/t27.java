package ThinkingInJava.Practise354_400.Practise391;

import java.util.ArrayList;
import java.util.List;


class temp1 {}

class temp11 extends temp1 {}

class temp111 extends temp11 {}

public class t27 {
    public static void main(String[] args) {
        List<? super temp11> myList = new ArrayList<>();
        //是temp11的某种基类型的list，故可以向其添加temp11的子类
        //取出只可
        //myList.add(new temp1());      //error
        myList.add(new temp11());
        myList.add(new temp111());
        Object o = myList.get(0);
        temp1 t1 = (temp1) o;

        System.out.println(t1);

        List<? extends temp11> myEList = new ArrayList<>();
        //是temp11的某种子类型的list，故不可以向其添加，
        //myEList.add(new temp1());      //error
        //myEList.add(new temp11());     //error
        //myEList.add(new temp111());


    }
}
