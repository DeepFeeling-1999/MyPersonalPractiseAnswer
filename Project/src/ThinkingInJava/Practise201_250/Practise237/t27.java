package ThinkingInJava.Practise201_250.Practise237;

import java.util.LinkedList;
import java.util.Queue;

class command{
    private String st;

    public command(String st){
        this.st=st;
    }
    public void operation(){
        System.out.println("st "+st);
    }
}
class test{
   private Queue<command> q=new LinkedList<>();

   public Queue<command> fun(){
       for(int i=0;i<3;i++){
           q.offer(new command(i+" "));
       }
       return q;
   }
}
public class t27 {
    public static void test(Queue<command> q){
        while(q.peek()!=null){
            q.poll().operation();
        }
    }
    public static void main(String[]args){
        test t=new test();
        test(t.fun());
    }
}
