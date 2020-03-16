package ThinkingInJava.Practise192;

class temp{
    private String st;

    @Override
    public String toString(){
        return "temp + "+st;
    }
}
interface selector{
    boolean end();
    Object current();
    void next();
}
class sequence{
    private Object[]items;
    private int next =0;
    public sequence(int size){items=new Object[size];}
    public void add(Object x){
        if(next<items.length)
            items[next++]=x;
    }

    private class SequenceSelector implements selector{
        private int i=0;
        public boolean end(){return i==items.length;}
        public Object current(){return items[i];}
        public void next(){
            if(i<items.length)
                i++;
        }
    }

    public selector selector(){
        return new SequenceSelector();
    }

    public static void main(String[]args){
        sequence se=new sequence(3);
        for(int i=0;i<3;i++)

    }
}
public class t2
{
}
