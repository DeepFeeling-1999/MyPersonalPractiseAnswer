package ThinkingInJava.Practise201_250.Practise228;

import java.util.*;

public class t12
{
    public static void main(String[]args){
        List<Integer> li1=new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        List<Integer> li2=new ArrayList<>(li1);
        ListIterator<Integer> i1=li1.listIterator();
        ListIterator<Integer>i2=li2.listIterator();
        
        while(i1.hasNext())
            i1.next();
        while(i2.hasNext())
        {
            i2.next();
            i2.set(i1.previous());
        }

        System.out.println(li1);
        System.out.println(li2);

    }
}
