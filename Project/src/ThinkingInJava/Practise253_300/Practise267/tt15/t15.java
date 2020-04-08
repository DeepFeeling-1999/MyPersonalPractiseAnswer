package ThinkingInJava.Practise253_300.Practise267.tt15;

class Switch {
    private boolean state=false;
    public boolean read() {
        return state;
    }

    public void on(){
        state=true;
        System.out.println(this);
    }
    public void off(){
        state=false;
        System.out.println(this);
    }
    @Override
    public String toString() {
        return state?"true":"false";
    }

}
class temp1 extends Exception{}
class temp2 extends Exception{}

public class t15 {
    private static Switch sw=new Switch();
    private static Integer[]x=new Integer[1];
    public static void f(int i)throws temp1, temp2 {
    }

    public static void main(String[]args){
        try {
            sw.on();
           f(x[0]);
        }catch(temp1 e){
            System.out.println("temp1");
        }catch (temp2 e){
            System.out.println("temp2");
        }finally {
            sw.off();
        }
    }
}
