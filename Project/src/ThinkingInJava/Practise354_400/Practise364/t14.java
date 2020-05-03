package ThinkingInJava.Practise354_400.Practise364;

import java.lang.reflect.InvocationTargetException;


class temp111 {
    int num;

    public temp111(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "temp111 + " + num;
    }
}
class BasicGenerator<T> implements myGenerator<T>{
    private Class<T> type;

    public BasicGenerator(Class<T> temp1Class) {
        type=temp1Class;
    }

    @Override
    public T next(int num) {
       try{
           return type.newInstance();
       } catch (IllegalAccessException e) {
           System.out.println("IllegalAccessException");
           e.printStackTrace();
       } catch (InstantiationException e) {
           System.out.println("InstantiationException");
           e.printStackTrace();
       }

        return null;
    }

}
public class t14 {
    public static void main(String[]args){
        myGenerator<temp111> gen=new BasicGenerator<temp111>(temp111.class);

        for(int i=0;i<3;i++){
            System.out.println(gen.next(i));
        }
    }
}
