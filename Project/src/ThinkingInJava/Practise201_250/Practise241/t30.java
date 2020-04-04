package ThinkingInJava.Practise201_250.Practise241;

import java.util.Iterator;
import java.util.Random;

class temp{
    private int num;

    public temp(int num){
        this.num=num;
    }
    @Override
    public String toString(){
        return "num "+num;
    }
}

public class t30 implements Iterable<temp>
{
    private temp[] temps;
    private Random r=new Random(33);

    public t30(int num){
        temps=new temp[num];
        for(int i=0;i<num;i++)
            temps[i]=new temp(r.nextInt(6));
    }
    @Override
    public Iterator<temp> iterator(){
        return new Iterator<temp>(){
            private int index=0;

            @Override
            public boolean hasNext(){
                return index<temps.length;
            }
            @Override
            public temp next(){
                return temps[index++];
            }
            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[]args){
        t30 ttttt=new t30(6);

        for(temp t:ttttt)
            System.out.println(t);
    }
}
