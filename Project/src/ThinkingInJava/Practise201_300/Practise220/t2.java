package ThinkingInJava.Practise201_300.Practise220;

import java.util.HashSet;
import java.util.Set;

public class t2
{
    public static void main(String[]args){
        Set<Integer> c=new HashSet<Integer>();
        for(int i=0;i<3;i++)
            c.add(i);
        for (Integer t:c) {
            System.out.print(t + " ");
        }
    }
}
