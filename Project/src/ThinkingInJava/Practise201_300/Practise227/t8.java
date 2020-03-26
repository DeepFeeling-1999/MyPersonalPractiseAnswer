package ThinkingInJava.Practise201_300.Practise227;

import java.util.ArrayList;
import java.util.Iterator;

class temp1{
    int t1;
    public temp1(int t1){
        this.t1=t1;
    }

    public void fun(){
        System.out.println(t1+" jump");
    }
}
public class t8
{
    public static void main(String[]args){
        ArrayList<temp1> ar1=new ArrayList<temp1>();
        for(int i=0;i<3;i++)
            ar1.add(new temp1(i));

        Iterator<temp1>i1=ar1.iterator();
        while(i1.hasNext())
            i1.next().fun();

    }
}