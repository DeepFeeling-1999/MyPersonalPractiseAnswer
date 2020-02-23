package ThinkingInJava.Practise150;

class bicycle extends cycle{
    @Override
    public void ride(){
        System.out.println("bicycle");
    }
}
class tricycle extends cycle{
    @Override
    public void ride(){
        System.out.println("tricycle");
    }
}
class cycle{
    public void ride(){
        System.out.println("cycle");
    }
}
public class t1{
    public static void main(String[]args){
        cycle [] array={
                new cycle(),
                new tricycle(),
                new bicycle(),
        };

        for (cycle c:array
        ) {
            c.ride();
        }
    }
}