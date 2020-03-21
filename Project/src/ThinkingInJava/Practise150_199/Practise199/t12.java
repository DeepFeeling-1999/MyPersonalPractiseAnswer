package ThinkingInJava.Practise150_199.Practise199;

interface Inner12{
    void fun();
}

class test{

    public Inner12 AnonymousInnerClass(){
        return new Inner12()
        {
            @Override
            public void fun()
            {
                System.out.println("Anonymous Inner Class");
            }
        };
    }
}
public class t12{
    public static void main(String[]args){
        (new test()).AnonymousInnerClass().fun();
    }
}